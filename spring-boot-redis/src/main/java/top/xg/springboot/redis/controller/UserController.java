package top.xg.springboot.redis.controller;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import io.micrometer.common.util.StringUtils;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
//import org.apache.commons.lang3.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.xg.springboot.redis.cache.TokenStoreCache;
import top.xg.springboot.redis.enums.ErrorCode;
import top.xg.springboot.redis.exception.ServerException;
import top.xg.springboot.redis.result.Result;
import top.xg.springboot.redis.service.UserService;
import top.xg.springboot.redis.utils.JwtUtil;
import top.xg.springboot.redis.vo.UserInfoVO;
import top.xg.springboot.redis.vo.UserLoginVO;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final TokenStoreCache tokenStoreCache;

    @PostMapping("/login")
    @Operation(summary = "收集短信登录")
    public Result<UserLoginVO> loginByPhone(@RequestParam("phone") String phone, @RequestParam("code") String code) {
        return Result.ok(userService.loginByPhone(phone, code));
    }

    @GetMapping("info")
    @Operation(summary = "查询用户信息")
    public Result<UserInfoVO> userInfo(){
        HttpServletRequest request = ((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest();
        String accessToken = JwtUtil.getAccessToken(request);
        if (StringUtils.isBlank(accessToken)) {
            throw new ServerException(ErrorCode.UNAUTHORIZED);
        }
        if (!JwtUtil.validate(accessToken)) {
            throw new ServerException(ErrorCode.UNAUTHORIZED);
        }
        UserLoginVO user = tokenStoreCache.getUser(accessToken);
        if (ObjectUtils.isEmpty(user)) {
            throw new ServerException(ErrorCode.LOGIN_STATUS_EXPIRE);
        }
        boolean enabledFlag = userService.checkUserEnable(user.getPkId());
        if (!enabledFlag) {
            throw new ServerException(ErrorCode.ACCOUNT_DISABLED);
        }
        return Result.ok(userService.userInfo(user.getPkId()));
    }
}
