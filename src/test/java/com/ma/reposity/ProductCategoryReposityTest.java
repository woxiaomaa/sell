package com.ma.reposity;

import com.ma.entity.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mh on 2018/7/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryReposityTest {
    @Autowired
    private ProductCategoryReposity productCategoryReposity;

    @Test
    public void insert(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("吃的");
        productCategory.setCategoryType(2);

        productCategoryReposity.save(productCategory);
    }

    @Test
    public void get(){
        ProductCategory productCategory = productCategoryReposity.findOne(1);
        System.out.println(productCategory.getCategoryName());
    }

    @Test
    public void update(){
        ProductCategory productCategory = productCategoryReposity.findOne(1);
        productCategory.setCategoryName("食物");
        productCategoryReposity.save(productCategory);
    }

    @Test
    public void findByCategoryType(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        List<ProductCategory> productCategories = productCategoryReposity.findByCategoryTypeIn(list);
        productCategories.forEach(System.out::println);
    }

}