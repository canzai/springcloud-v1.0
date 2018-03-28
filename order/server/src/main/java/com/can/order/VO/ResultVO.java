package com.can.order.VO;

import lombok.Data;

/**
 * @author Chench
 * @date 2018/3/25  17:00
 */
@Data
public class ResultVO<T> {
    private Integer code;

    private String msg;

    private T data;
}
