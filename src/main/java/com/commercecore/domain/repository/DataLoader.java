package com.commercecore.domain.repository;

import com.commercecore.domain.entity.Product;
import com.commercecore.domain.entity.enums.Category;
import com.commercecore.domain.entity.enums.Currency;
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
                .articleName("Surface Pro")
                .price(1199.99)
                .producer("Microsoft")
                .currency(Currency.EURO)
                .stock(2)
                .categories(Category.TECH)
                .build();

        Product iphone = Product.builder()
                .articleNumber(544695111556544L)
                .articleName("iPhone Pro Max 15")
                .price(1499.99)
                .producer("Apple")
                .currency(Currency.EURO)
                .stock(5)
                .categories(Category.TECH)
                .build();

        Product iphone2 = Product.builder()
                .articleNumber(544295111556544L)
                .articleName("iPhone 12")
                .price(899.99)
                .producer("Apple")
                .currency(Currency.EURO)
                .stock(30)
                .categories(Category.TECH)
                .build();

        Product macBook = Product.builder()
                .articleNumber(544295111336544L)
                .articleName("MacBook Air Pro")
                .price(1599.99)
                .producer("Apple")
                .currency(Currency.EURO)
                .stock(30)
                .categories(Category.TECH)
                .build();

        Product shoes = Product.builder()
                .articleNumber(544623585556544L)
                .articleName("Air Max")
                .price(199.99)
                .producer("Nike")
                .currency(Currency.EURO)
                .stock(50)
                .categories(Category.FASHION)
                .build();

        Product shoes2 = Product.builder()
                .articleNumber(544695583556544L)
                .articleName("Flat shoes")
                .price(59.99)
                .producer("VANS")
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
