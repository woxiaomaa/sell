package com.ma.util;

import com.ma.viewobject.ProductVO;
import com.ma.viewobject.ResultVO;

import java.util.List;

/**
 * Created by mh on 2018/7/21.
 */
public class ResultVOUtil {
    public static ResultVO<ProductVO> success(List<ProductVO> productVOList){
        ResultVO<ProductVO> resultVO = new ResultVO<>();
        resultVO.setCode(0);
        resultVO.setMsg("success");
        resultVO.setData(productVOList);
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code,String message){
        ResultVO resultVO = new ResultVO(code,message);
        return resultVO;
    }

}
