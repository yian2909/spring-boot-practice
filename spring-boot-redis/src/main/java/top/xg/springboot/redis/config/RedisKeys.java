package top.xg.springboot.redis.config;

/**
 * @author Lenovo
 */
public class RedisKeys {
    //验证码的key
    public static String getSmsKey(String phone) {
        return "sms:captcha" + phone;
    }

    public static String getAccessTokenKey(String accessToken){
        return "sys:access:" + accessToken;
    }

    public static String getUserIdKey(Long id){
        return "sys:userId:" + id;
    }
}
