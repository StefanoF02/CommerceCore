package com.commercecore.productService.entity.repository;

import com.commercecore.productService.entity.Product;
import com.commercecore.productService.entity.enums.Category;
import com.commercecore.productService.entity.enums.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DataLoader implements ApplicationRunner {

    private ProductRepository productRepository;

    @Autowired
    public DataLoader(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Product surface = Product.builder()
                .articleNumber(544695526556544L)
                .articleName("surface pro")
                .price(1199.99)
                .producer("microsoft")
                .currency(Currency.EURO)
                .stock(2)
                .categories(Category.TECH)
                .build();

        Product iphone = Product.builder()
                .articleNumber(544695111556544L)
                .articleName("iPhone Pro Max 15")
                .price(1499.99)
                .producer("apple")
                .currency(Currency.EURO)
                .stock(5)
                .categories(Category.TECH)
                .build();

        Product iphone2 = Product.builder()
                .articleNumber(544295111556544L)
                .articleName("iPhone 12")
                .price(899.99)
                .producer("apple")
                .currency(Currency.EURO)
                .stock(30)
                .categories(Category.TECH)
                .build();

        Product macBook = Product.builder()
                .articleNumber(544295111336544L)
                .articleName("macBook air pro")
                .price(1599.99)
                .producer("apple")
                .currency(Currency.EURO)
                .stock(30)
                .categories(Category.TECH)
                .build();

        Product shoes = Product.builder()
                .articleNumber(544623585556544L)
                .articleName("air max")
                .price(199.99)
                .producer("nike")
                .currency(Currency.EURO)
                .stock(50)
                .categories(Category.FASHION)
                .build();

        Product shoes2 = Product.builder()
                .articleNumber(544695583556544L)
                .articleName("flat shoes")
                .price(59.99)
                .producer("vANS")
                .currency(Currency.EURO)
                .stock(20)
                .categories(Category.FASHION)
                .build();

        productRepository.saveOrUpdateProduct(surface);
        productRepository.saveOrUpdateProduct(iphone);
        productRepository.saveOrUpdateProduct(iphone2);
        productRepository.saveOrUpdateProduct(macBook);
        productRepository.saveOrUpdateProduct(shoes);
        productRepository.saveOrUpdateProduct(shoes2);

    }
}
