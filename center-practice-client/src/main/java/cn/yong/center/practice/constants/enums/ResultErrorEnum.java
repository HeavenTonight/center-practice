package cn.yong.center.practice.constants.enums;

import cn.yong.common.enums.BaseEnum;

public enum ResultErrorEnum implements BaseEnum {
    USER_PASSWORD_ERROR(40110,"用户名或者密码错误！"),
    PARAM_ERROR(40111,"参数错误！"),
    ;

    private Integer code;

    private String msg;

    ResultErrorEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
