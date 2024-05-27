package com.commercecore.api.controller;

import com.commercecore.domain.entity.Product;
import com.commercecore.domain.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{articleNumber}")
    public ResponseEntity<Product> getProduct(@PathVariable Long articleNumber){
        var product = this.productService.findByArtNumber(articleNumber);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProductsByProducer(@RequestParam("producer") String producer){
        List<Product> productsList = this.productService.findAllByProducer(producer);
        return new ResponseEntity<>(productsList,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product){
        this.productService.saveProduct(product);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Product> updateProduct(@Valid @RequestBody Product product){
        this.productService.updateProduct(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/{articleNumber}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable Long articleNumber){
        var product = this.productService.deleteProduct(articleNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
