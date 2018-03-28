package com.can.order.repository;

import com.can.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Chench
 * @date 2018/3/25  12:09
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String>{
}
