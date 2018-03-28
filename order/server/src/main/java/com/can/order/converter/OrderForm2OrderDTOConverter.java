package com.can.order.converter;

import com.can.order.dataobject.OrderDetail;
import com.can.order.dto.OrderDTO;
import com.can.order.enums.ResultEnum;
import com.can.order.exception.OrderException;
import com.can.order.form.OrderForm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chench
 * @date 2018/3/25  16:37
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetails = new ArrayList<>();

        Gson gson = new Gson();
        try {
            orderDetails = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.
                            getType());
        } catch (Exception e) {
            log.error("【json转换】错误, String={}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetails(orderDetails);

        return orderDTO;
    }
}
