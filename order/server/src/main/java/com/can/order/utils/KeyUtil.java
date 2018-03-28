package com.can.order.utils;

import java.util.Random;

/**
 * @author Chench
 * @date 2018/3/25  16:21
 */
public class KeyUtil {
    /**
     * 生成唯一的主键(简单应用)
     * 格式：时间戳+随机数
     * synchronized：避免多线程情况下生成同样的订单号
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
