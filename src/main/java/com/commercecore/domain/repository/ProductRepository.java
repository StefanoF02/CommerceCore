package com.commercecore.domain.repository;

import com.commercecore.domain.entity.Product;

public interface ProductRepository {

    void saveProduct(Product product);

    Product findByArtNumber(Integer articleNumber);



}
