package com.can.order.service;

import com.can.order.dto.OrderDTO;

/**
 * @author Chench
 * @date 2018/3/25  16:13
 */
public interface OrderService {
    /**
     * 创建订单
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);
}
