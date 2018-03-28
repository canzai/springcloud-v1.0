package com.can.order.utils;

import com.can.order.VO.ResultVO;

/**
 * @author Chench
 * @date 2018/3/25  17:02
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }
}
