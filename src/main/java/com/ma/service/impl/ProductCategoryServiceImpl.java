package com.ma.service.impl;

import com.ma.entity.ProductCategory;
import com.ma.reposity.ProductCategoryReposity;
import com.ma.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mh on 2018/7/21.
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryReposity productCategoryReposity;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return productCategoryReposity.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryReposity.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryReposity.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryReposity.save(productCategory);
    }
}
