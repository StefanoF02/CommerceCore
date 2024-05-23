package com.commercecore.domain.repository;

import com.commercecore.domain.entity.Product;

import java.util.Optional;

public interface ProductRepository {

    boolean exists(Integer articleNumber);

    boolean exists(Product product);

    void saveOrUpdateProduct(Product product);

    Optional<Product> findByArtNumber(Integer articleNumber);

    void deleteProduct(Product product);

}
