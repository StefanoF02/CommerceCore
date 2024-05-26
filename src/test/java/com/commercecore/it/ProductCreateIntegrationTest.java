package com.commercecore.it;

import com.commercecore.domain.entity.Category;
import com.commercecore.domain.entity.Product;
import com.commercecore.domain.repository.ProductRepository;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@Testcontainers
@RunWith(SpringRunner.class)
public class ProductCreateIntegrationTest {

    private Product product;

    @Autowired
    ProductRepository productRepository;

    @Rule
    public PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:latest");

    @Test
    void test(){
        product = Product.builder()
                .articleNumber(544695585556554L)
                .articleName("Test")
                .price(13.3)
                .producer("Apple")
                .stock(2)
                .categories(Category.MODE)
                .reviews(new ArrayList<>())
                .build();
        productRepository.saveOrUpdateProduct(product);

        var retrievedProduct = productRepository.findByArtNumber(544695585556554L);

        System.out.println(retrievedProduct);
        assertEquals(product, retrievedProduct.get());

    }

}
