package com.can.product.service;

import com.can.product.common.DecreaseStockInput;
import com.can.product.dataobject.ProductInfo;

import java.util.List;

/**
 * @author Chench
 * @date 2018/3/25  9:39
 */
public interface ProductService {
    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     * @param productIds
     * @return
     */
    List<ProductInfo> findList(List<String> productIds);

    /**
     * 扣库存
     * @param decreaseStockInputs
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputs);
}
