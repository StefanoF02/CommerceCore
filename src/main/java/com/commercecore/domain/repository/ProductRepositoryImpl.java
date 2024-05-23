package com.commercecore.domain.repository;

import com.commercecore.domain.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@AllArgsConstructor
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private final EntityManager entityManager;

    @Override
    public boolean exists(Integer articleNumber){
        return findByArtNumber(articleNumber).isPresent();
    }

    @Override
    public boolean exists(Product product){
        var found = Optional.ofNullable(this.entityManager.find(Product.class, product));
        if(found.isPresent()){
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public void saveOrUpdateProduct(Product product){
        this.entityManager.merge(product);
    }

    @Override
    public Optional<Product> findByArtNumber(Integer articleNumber) {
        return Optional.ofNullable(this.entityManager.find(Product.class, articleNumber));
    }

    @Override
    @Transactional
    public void deleteProduct(Product product) {
        entityManager.remove(product);
    }
}
