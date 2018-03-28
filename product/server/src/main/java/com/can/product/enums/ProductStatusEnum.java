package com.can.product.enums;

/**
 * 商品上下架状态
 * @author Chench
 * @date 2018/3/25  9:42
 */

import lombok.Getter;

@Getter
public enum ProductStatusEnum {
    UP(0, "在架"),
    DOWN(1, "下架"),
    ;

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
