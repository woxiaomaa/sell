package com.ma.service;

import com.ma.dto.CartDTO;
import com.ma.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by mh on 2018/7/21.
 */
public interface ProductInfoService {
    ProductInfo findOne(String productId);

    List<ProductInfo> findUpProduct();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);


}
