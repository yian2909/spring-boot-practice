package top.ssy.share.app.common.constant;

/**
 * @author Lenovo
 */
public interface Constant {
    //    创建时间
    String CREATE_TIME = "createTime";
    //    更新时间
    String UPDATE_TIME = "updateTime";
    //   逻辑删除
    String DELETE_FLAG = "deleteFlag";
    // 用户id
    String USER_ID = "userId";

    // 微信小程序 appId
    String APP_ID = "wx1f682508ff299f79";
    // appSecret
    String APP_SECRET = "594a4593c19e6401b41b7f857a19058b";
    // 微信返回参数中的属性名
    String WX_ERR_CODE = "errcode";
    // 返回参数中的属性名
    String WX_OPENID = "openid";
    // 返回参数中的属性名
    String WX_SESSION_KEY = "session_key";
    // 前端没有登录的时候会携带的token，后续会用到
    String NO_TOKEN = "no-token";
}
