package com.can.order.repository;

import com.can.order.OrderApplicationTests;
import com.can.order.dataobject.OrderMaster;
import com.can.order.enums.OrderStatusEnum;
import com.can.order.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


/**
 * @author Chench
 * @date 2018/3/25  12:12
 */
@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests{
    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("云韵");
        orderMaster.setBuyerPhone("18863636636");
        orderMaster.setBuyerAddress("纳木措");
        orderMaster.setBuyerOpenid("369852756");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertNotNull(result);
    }
}