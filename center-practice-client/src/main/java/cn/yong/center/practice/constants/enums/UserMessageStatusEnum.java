package cn.yong.center.practice.constants.enums;

public enum UserMessageStatusEnum {
    UN_READED(0,"未读"),
    READED(1,"已读"),;
    private Integer code;
    private String msg;
    UserMessageStatusEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
