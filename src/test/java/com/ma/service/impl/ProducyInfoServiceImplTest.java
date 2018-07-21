package com.ma.service.impl;

import com.ma.entity.ProductInfo;
import com.ma.reposity.ProductInfoReposity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by mh on 2018/7/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProducyInfoServiceImplTest {
   @Autowired
   private ProductInfoReposity productInfoReposity;

    @Test
    public void findAll() throws Exception {
        PageRequest pageRequest = new PageRequest(0,2);
        Page<ProductInfo> productInfos = productInfoReposity.findAll(pageRequest);
        System.out.println(productInfos.getContent());
    }

}