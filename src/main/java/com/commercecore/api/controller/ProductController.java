package com.commercecore.api.controller;

import com.commercecore.domain.entity.Product;
import com.commercecore.domain.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    // TODO Validation missing
    @PostMapping("/products")
    public ResponseEntity<HttpStatus> saveProduct(@RequestBody Product product){
        this.productService.saveProduct(product);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

}
