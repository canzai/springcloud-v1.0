package com.can.product.service;

import com.can.product.ProductApplicationTests;
import com.can.product.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author Chench
 * @date 2018/3/25  10:12
 */
@Component
public class CategoryServiceTest extends ProductApplicationTests{
    @Autowired
    private CategoryService categoryService;

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> productCategories = categoryService.findByCategoryTypeIn(Arrays.asList(11, 22));
        Assert.assertTrue(productCategories.size() > 0);
    }

}