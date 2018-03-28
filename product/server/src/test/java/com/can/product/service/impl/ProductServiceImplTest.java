package com.can.product.service.impl;

import com.can.product.ProductApplicationTests;
import com.can.product.dataobject.ProductInfo;
import com.can.product.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author Chench
 * @date 2018/3/25  21:09
 */
@Component
public class ProductServiceImplTest extends ProductApplicationTests{

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() throws Exception {
    }

    @Test
    public void findList() throws Exception {
        List<ProductInfo> productInfos = productService.findList(Arrays.asList("157875196366160022", "157875227953464068"));
        Assert.assertTrue(productInfos.size() > 0);

    }

}