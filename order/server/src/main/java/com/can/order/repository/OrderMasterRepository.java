package com.can.order.repository;

import com.can.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Chench
 * @date 2018/3/25  12:08
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
