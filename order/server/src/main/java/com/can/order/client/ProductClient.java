package com.can.order.client;


import com.can.order.dataobject.ProductInfo;
import com.can.order.dto.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author Chench
 * @date 2018/3/25  20:57
 */
@FeignClient(name = "product")
public interface ProductClient {

    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(@RequestBody List<String> productIds);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<CartDTO> cartDTOS);
}
