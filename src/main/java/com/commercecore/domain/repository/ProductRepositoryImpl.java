package com.commercecore.domain.repository;

import com.commercecore.domain.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private final EntityManager entityManager;

    @Override
    @Transactional
    public void saveProduct(Product product){
        this.entityManager.persist(product);
    }

    @Override
    public Product findByArtNumber(Integer articleNumber) {
        return this.entityManager.find(Product.class, articleNumber);
    }
}
