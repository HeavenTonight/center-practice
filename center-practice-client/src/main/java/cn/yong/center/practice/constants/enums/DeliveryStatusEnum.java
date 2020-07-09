package cn.yong.center.practice.constants.enums;

/** 配送状态枚举
 * @author ogy
 */
public enum DeliveryStatusEnum{

    UNASSIGNED(0, "待分配"),

    PENDING_DELIVERY(1, "待配送"),

    SHIPPING(2, "配送中"),

    DELIVERY_COMPLETE(3, "配送已完成"),

    DELIVERY_ABNORMAL(4, "配送异常"),
    ;

    private Integer code;

    private String msg;

    DeliveryStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}