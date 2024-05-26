package com.commercecore.api.controller;

import com.commercecore.domain.entity.Product;
import com.commercecore.domain.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController()
public class ProductController {

    private final ProductService productService;

    // TODO Validation missing
    @PostMapping("/products")
    public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product){
        this.productService.saveProduct(product);
        return new ResponseEntity<Product>(product,HttpStatus.OK);
    }

    @PatchMapping("/products")
    public ResponseEntity<Product> updateProduct(@Valid @RequestBody Product product){
        this.productService.updateProduct(product);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @GetMapping("/products/{articleNumber}")
    public ResponseEntity<Product> getProduct(@PathVariable Long articleNumber){
        var product = this.productService.findByArtNumber(articleNumber);
        return new ResponseEntity<Product>(product,HttpStatus.OK);
    }

    @DeleteMapping("/products/{articleNumber}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable Long articleNumber){
        var product = this.productService.deleteProduct(articleNumber);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }


}
