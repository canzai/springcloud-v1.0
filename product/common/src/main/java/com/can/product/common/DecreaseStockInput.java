package com.can.product.common;

import lombok.Data;

/**
 * 减库存入参
 * @author Chench
 * @date 2018/3/27  8:32
 */
@Data
public class DecreaseStockInput {
    private String productId;

    private Integer productQuantity;

    private String branch;

    private String newBranch;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

}
