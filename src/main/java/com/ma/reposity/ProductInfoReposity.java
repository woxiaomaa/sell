package com.ma.reposity;

import com.ma.entity.ProductCategory;
import com.ma.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by mh on 2018/7/21.
 */
public interface ProductInfoReposity extends JpaRepository<ProductInfo,String> {
    List<ProductInfo> findByProductStatus(Integer productStatus);

}
