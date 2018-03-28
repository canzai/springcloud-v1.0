package com.can.product.utils;

import com.can.product.VO.ResultVO;

/**
 * @author Chench
 * @date 2018/3/25  10:51
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
