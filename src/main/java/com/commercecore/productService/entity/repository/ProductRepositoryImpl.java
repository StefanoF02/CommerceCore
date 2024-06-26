package com.commercecore.productService.entity.repository;

import com.commercecore.productService.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private final EntityManager entityManager;

    @Override
    public boolean exists(Long articleNumber){
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
    public Optional<Product> findByArtNumber(Long articleNumber) {
        return Optional.ofNullable(this.entityManager.find(Product.class, articleNumber));
    }

    @Override
    public List<Product> findAllByProducer(String producer) {
        TypedQuery<Product> query = entityManager.
                createQuery("FROM Product WHERE producer=:request", Product.class)
                .setParameter("request", producer);
        return query.getResultList();
    }

    @Override
    public List<Product> findAllByCategories(String category) {
        return List.of();
    }

    @Override
    @Transactional
    public void deleteProduct(Product product) {
        entityManager.remove(product);
    }
}
