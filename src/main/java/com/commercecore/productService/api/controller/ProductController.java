package com.commercecore.productService.api.controller;

import com.commercecore.productService.api.model.ProductAo;
import com.commercecore.productService.entity.Product;
import com.commercecore.productService.service.ProductService;
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
    public ResponseEntity<ProductAo> getProduct(@PathVariable Long articleNumber){
        var product = this.productService.findByArtNumber(articleNumber);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductAo>> getProductsByProducer(@RequestParam("producer") String producer){
        List<ProductAo> productsList = this.productService.findAllByProducer(producer);
        return new ResponseEntity<>(productsList,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductAo> saveProduct(@Valid @RequestBody Product product){
        return new ResponseEntity<>(this.productService.saveProduct(product),HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<ProductAo> updateProduct(@Valid @RequestBody Product product){
        return new ResponseEntity<>(this.productService.updateProduct(product), HttpStatus.OK);
    }

    @DeleteMapping("/{articleNumber}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable Long articleNumber){
        var product = this.productService.deleteProduct(articleNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
