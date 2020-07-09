package cn.yong.center.practice.constants.enums;

import lombok.Data;
import lombok.Getter;

//统计方式枚举
@Getter
public enum StatisticsEnum {
    HOT_HEAT(0,"热度"),
    HOT_TOP(1,"排名"),
    HOT_MARK(2,"标识"),
    ;
    private Integer code;
    private String msg;

    StatisticsEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
