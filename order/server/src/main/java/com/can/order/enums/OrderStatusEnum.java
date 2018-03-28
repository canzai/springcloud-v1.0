package com.can.order.enums;

import lombok.Getter;

/**
 * @author Chench
 * @date 2018/3/25  13:47
 */
@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISH(1, "完结"),
    CANCEL(2, "取消"),
    ;

    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
