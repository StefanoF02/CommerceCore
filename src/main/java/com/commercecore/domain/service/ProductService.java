package com.commercecore.domain.service;

import com.commercecore.api.mapper.ProductMapper;
import com.commercecore.api.model.ProductAo;
import com.commercecore.domain.entity.Product;
import com.commercecore.domain.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final ProductMapper productMapper;

    public ProductAo saveProduct(Product product) {
        this.productRepository.saveOrUpdateProduct(product);
        return productMapper.toApi(product);
    }

    public ProductAo updateProduct(Product product) {
        if(!this.productRepository.exists(product.getArticleNumber())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Product with article number " + product.getArticleNumber() + " not found");
        }
        this.productRepository.saveOrUpdateProduct(product);
        return productMapper.toApi(product);
    }

    public ProductAo findByArtNumber(Long articleNumber) {
        return productMapper.toApi( productRepository.findByArtNumber(articleNumber).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Product with article number " + articleNumber + " not found")));
    }

    public List<ProductAo> findAllByProducer(String producer){
        List<ProductAo> productsByProducer = new ArrayList<>();

        productRepository.findAllByProducer(producer)
                .forEach(product -> productsByProducer.add(productMapper.toApi(product)));

        return productsByProducer;
    }

    public HttpStatus deleteProduct(Long articleNumber) {
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
