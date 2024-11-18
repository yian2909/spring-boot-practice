package top.ssy.share.app.enums;

import lombok.Getter;

/**
 * @author Lenovo
 */
@Getter
public enum ResourceStatusEnum {
    UNAUDITED(0,"未审核"),
    AUDITED(1,"审核通过"),
    NOT_AUDITED(2,"审核不通过")
    ;

    private final Integer code;
    private final String status;

    ResourceStatusEnum(Integer code,String status){
        this.code=code;
        this.status=status;
    }
}
