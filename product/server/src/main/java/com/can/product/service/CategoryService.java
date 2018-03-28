package com.can.product.service;

import com.can.product.dataobject.ProductCategory;

import java.util.List;

/**
 * @author Chench
 * @date 2018/3/25  10:09
 */
public interface CategoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
