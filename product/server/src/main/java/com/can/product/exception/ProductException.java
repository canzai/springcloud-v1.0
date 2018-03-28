package com.can.product.exception;

import com.can.product.enums.ResultEnum;

/**
 * @author Chench
 * @date 2018/3/25  21:30
 */
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
