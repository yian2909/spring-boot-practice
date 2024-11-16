package top.ssy.share.app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import top.ssy.share.app.common.result.Result;
import top.ssy.share.app.model.dto.WxLoginDTO;
import top.ssy.share.app.model.vo.UserLoginVO;
import top.ssy.share.app.service.AuthService;

/**
 * @author Lenovo
 */
@RestController
@RequestMapping("/auth")
@Tag(name = "认证接口")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/lofin")
    @Operation(summary = "手机号登录")
    public Result<UserLoginVO> loginByPhone(@RequestParam("phone")String phone, @RequestParam("code")String code){
        return Result.ok(authService.loginByPhone(phone,code));
    }

    @PostMapping("weChatLogin")
    public Result<UserLoginVO> weChatLogin(@RequestBody WxLoginDTO dto){
        return Result.ok(authService.weChatLogin(dto));
    }

    @PostMapping("/logout")
    @Operation(summary="登出")
    public Result<Object> logout(){
        authService.logout();
        return Result.ok();
    }

    @PostMapping("/bindPhone")
    @Operation(summary="绑定手机号")
    public Result<String> bindPhone(@RequestParam("phone")String phone,@RequestParam("code")String code,@RequestHeader("Authorization")String accessToken){
        authService.bindPhone(phone,code,accessToken);
        return Result.ok();
    }
}
