package com.can.order.dto;

import lombok.Data;

/**
 * @author Chench
 * @date 2018/3/25  21:25
 */
@Data
public class CartDTO {
    /**
     * 商品Id
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
