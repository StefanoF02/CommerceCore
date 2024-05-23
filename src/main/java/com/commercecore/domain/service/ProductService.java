package com.commercecore.domain.service;

import com.commercecore.domain.entity.Product;
import com.commercecore.domain.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Random;

@AllArgsConstructor
@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;

    public void saveProduct(Product product) {
        product.setArticleNumber(generateArticleNumber(product));
        this.productRepository.saveOrUpdateProduct(product);
    }

    public void updateProduct(Product product) {
        if(!this.productRepository.exists(product.getArticleNumber())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Product with article number " + product.getArticleNumber() + " not found");
        }
        this.productRepository.saveOrUpdateProduct(product);
    }

    public Product findByArtNumber(Integer articleNumber) {
        return productRepository.findByArtNumber(articleNumber).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Product with article number " + articleNumber + " not found"));
    }


    public HttpStatus deleteProduct(Integer articleNumber) {
        var product = productRepository.findByArtNumber(articleNumber);
        if (product.isPresent()) {
            productRepository.deleteProduct(product.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Product with article number " + articleNumber + " not found");
        }
        return HttpStatus.NO_CONTENT;
    }
}
