package com.can.product.repository;

import com.can.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @author Chench
 * @date 2018/3/24  11:17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> productInfos = productInfoRepository.findByProductStatus(0);
        Assert.assertTrue(productInfos.size() > 0);
    }

    @Test
    public void findByProductIdIn() throws Exception {
        List<ProductInfo> productInfos = productInfoRepository.findByProductIdIn(Arrays.asList("157875196366160022", "157875227953464068"));
        Assert.assertTrue(productInfos.size() > 0);
    }

}