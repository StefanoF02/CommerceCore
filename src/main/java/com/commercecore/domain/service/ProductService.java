package com.commercecore.domain.service;

import com.commercecore.domain.entity.Product;
import com.commercecore.domain.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;

    public void saveProduct(Product product){
        this.productRepository.saveProduct(product);
    }
}
