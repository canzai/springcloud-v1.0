package com.can.product.service;

import com.can.product.common.DecreaseStockInput;
import com.can.product.ProductApplicationTests;
import com.can.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author Chench
 * @date 2018/3/25  10:04
 */
@Component
public class ProductServiceTest extends ProductApplicationTests{

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> productInfos = productService.findUpAll();
        Assert.assertTrue(productInfos.size() > 0);
    }

    @Test
    public void decreaseStock() throws Exception {
        DecreaseStockInput decreaseStockInput = new DecreaseStockInput("157875196366160022", 1);
        productService.decreaseStock(Arrays.asList(decreaseStockInput));
    }
}