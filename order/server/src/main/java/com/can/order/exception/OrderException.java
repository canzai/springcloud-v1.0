package com.can.order.exception;

import com.can.order.enums.ResultEnum;

/**
 * @author Chench
 * @date 2018/3/25  16:31
 */
public class OrderException extends RuntimeException{
    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
