package com.commercecore.domain.repository;

import com.commercecore.domain.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    boolean exists(Long articleNumber);

    boolean exists(Product product);

    void saveOrUpdateProduct(Product product);

    Optional<Product> findByArtNumber(Long articleNumber);

    List<Product> findAllByProducer(String producer);

    List<Product> findAllByCategories(String category);

    void deleteProduct(Product product);

}
