package top.ssy.share.app.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Lenovo
 */
@Getter
@AllArgsConstructor
public enum UserActionEnum {
    COLLECT(0,"收藏"),
    PUBLISH(1,"发布"),
    EXCHANGE(2,"兑换"),
    LIKE(3,"点赞"),
    ;

    private final Integer code;
    private final String desc;

    public static UserActionEnum getByCode(Integer code){
        for(UserActionEnum value : values()){
            if(value.code.equals(code)){
                return value;
            }
        }
        return null;
    }
}
