package com.ma.service;

import com.ma.entity.ProductCategory;

import java.util.List;

/**
 * Created by mh on 2018/7/21.
 */
public interface ProductCategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
