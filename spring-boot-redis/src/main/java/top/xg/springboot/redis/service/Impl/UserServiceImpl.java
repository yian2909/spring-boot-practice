package top.xg.springboot.redis.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import top.xg.springboot.redis.cache.TokenStoreCache;
import top.xg.springboot.redis.config.RedisCache;
import top.xg.springboot.redis.config.RedisKeys;
import top.xg.springboot.redis.entity.User;
import top.xg.springboot.redis.enums.AccountStatusEnum;
import top.xg.springboot.redis.enums.ErrorCode;
import top.xg.springboot.redis.exception.ServerException;
import top.xg.springboot.redis.mapper.UserMapper;
import top.xg.springboot.redis.service.UserService;
import top.xg.springboot.redis.utils.JwtUtil;
import top.xg.springboot.redis.vo.UserInfoVO;
import top.xg.springboot.redis.vo.UserLoginVO;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author Lenovo
 */
@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private final RedisCache redisCache;
    private final TokenStoreCache tokenStoreCache;
    @Override
    public UserLoginVO loginByPhone(String phone, String code) {
        String smsCacheKey = RedisKeys.getSmsKey(phone);
        Integer redisCode = (Integer) redisCache.get(smsCacheKey);
        if (ObjectUtils.isEmpty(redisCode) || !redisCode.toString().equals(code)) {
            throw new ServerException(ErrorCode.SMS_CODE_ERROR);
        }
        redisCache.delete(smsCacheKey);
        User user = baseMapper.getByPhone(phone);
        if (ObjectUtils.isEmpty(user)) {
            log.info("用户不存在，创建用户，phone:{}", phone);
            user = new User();
            user.setNickname(phone);
            user.setPhone(phone);
            user.setAvatar("https://yian2909-bucket.oss-cn-hangzhou.aliyuncs.com/doc.jpg");
            user.setGender(0);
            user.setEnabled(AccountStatusEnum.ENABLED.getValue());
            user.setBonus(100);
            user.setDeleteFlag(0);
            user.setRemark("这个人很懒，什么都没有写");
            baseMapper.insert(user);
        }

        if (!user.getEnabled().equals(AccountStatusEnum.ENABLED.getValue())) {
            throw new ServerException(ErrorCode.ACCOUNT_DISABLED);
        }
        String accessToken = JwtUtil.createToken(user.getPkId());
        UserLoginVO userLoginVO = new UserLoginVO();
        userLoginVO.setPkId(user.getPkId());
        userLoginVO.setPhone(user.getPhone());
        userLoginVO.setAccessToken(accessToken);
        tokenStoreCache.saveUser(accessToken,userLoginVO);
        return userLoginVO;
    }

    @Override
    public boolean checkUserEnable(Long userId) {
        User user = baseMapper.selectById(userId);
        if (ObjectUtils.isEmpty(user)) {
            return false;
        }
        return user.getEnabled().equals(AccountStatusEnum.ENABLED.getValue());
    }

    @Override
    public UserInfoVO userInfo(Long userId) {
        User user = baseMapper.selectById(userId);
        if (user == null) {
            log.error("用户不存在,userId:{}", userId);
            throw new ServerException(ErrorCode.USER_NOT_EXIST);
        }
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtils.copyProperties(user, userInfoVO);
        return userInfoVO;
    }

    @Override
    public boolean saveBatch(Collection<User> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<User> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<User> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(User entity) {
        return false;
    }

    @Override
    public User getOne(Wrapper<User> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Optional<User> getOneOpt(Wrapper<User> queryWrapper, boolean throwEx) {
        return Optional.empty();
    }

    @Override
    public Map<String, Object> getMap(Wrapper<User> queryWrapper) {
        return Map.of();
    }

    @Override
    public <V> V getObj(Wrapper<User> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public Class<User> getEntityClass() {
        return null;
    }
}
