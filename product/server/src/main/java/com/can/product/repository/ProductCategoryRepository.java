package com.can.product.repository;

import com.can.product.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Chench
 * @date 2018/3/24  11:27
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
