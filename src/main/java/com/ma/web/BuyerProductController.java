package com.ma.web;

import com.ma.entity.ProductCategory;
import com.ma.entity.ProductInfo;
import com.ma.service.ProductCategoryService;
import com.ma.service.ProductInfoService;
import com.ma.util.ResultVOUtil;
import com.ma.viewobject.ProductInfoVO;
import com.ma.viewobject.ProductVO;
import com.ma.viewobject.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by mh on 2018/7/21.
 */
@RestController
@RequestMapping("/buyer/product/")
public class BuyerProductController {
    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping("list")
    public ResultVO getList(){
        List<ProductVO> productVOList = new ArrayList<>();
        /**
         * 找到所有categoryType
         *
         * */
        List<ProductInfo> productInfos = productInfoService.findUpProduct();
        Set<Integer> categoryTypeSet = productInfos.stream().map(ProductInfo::getCategoryType).collect(Collectors.toSet());
        List<Integer> categoryTypeList = new ArrayList<>(categoryTypeSet);

        /**
         * 把所有食物根据不同categoryTyoe分类
         *
         * */
        List<ProductCategory> productCategoryList= productCategoryService.findByCategoryTypeIn(categoryTypeList);
        for(ProductCategory productCategory : productCategoryList){
            ProductVO<ProductInfoVO> productVO = new ProductVO<>();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfos){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOs(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
