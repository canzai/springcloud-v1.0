package com.can.order.service.impl;

import com.can.order.client.ProductClient;
import com.can.order.dataobject.OrderDetail;
import com.can.order.dataobject.OrderMaster;
import com.can.order.dataobject.ProductInfo;
import com.can.order.dto.CartDTO;
import com.can.order.dto.OrderDTO;
import com.can.order.enums.OrderStatusEnum;
import com.can.order.enums.PayStatusEnum;
import com.can.order.repository.OrderDetailRepository;
import com.can.order.repository.OrderMasterRepository;
import com.can.order.service.OrderService;
import com.can.order.utils.KeyUtil;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Chench
 * @date 2018/3/25  16:14
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ProductClient productClient;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.genUniqueKey();
//      查询商品信息(调用商品服务)
        List<String> productIds = orderDTO.getOrderDetails().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfo> productInfos = productClient.listForOrder(productIds);
//      计算总价
        BigDecimal orderAmout = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail : orderDTO.getOrderDetails()) {
            for (ProductInfo productInfo : productInfos) {
                if (productInfo.getProductId().equals(orderDetail.getProductId())) {
                    orderAmout = productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmout);
                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    //订单详情入库
                    orderDetailRepository.save(orderDetail);
                }
            }
        }
//        扣库存(调用商品服务)
        List<CartDTO> cartDTOS = orderDTO.getOrderDetails().stream()
                .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(cartDTOS);

//        订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmout);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
