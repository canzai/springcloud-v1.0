package com.can.product.repository;

import com.can.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Chench
 * @date 2018/3/24  11:13
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String>{
    List<ProductInfo> findByProductStatus(Integer productStatus);

    List<ProductInfo> findByProductIdIn(List<String> productIds);
}
