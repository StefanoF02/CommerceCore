package com.commercecore.it.products;

import com.commercecore.domain.entity.Category;
import com.commercecore.domain.entity.Product;
import com.commercecore.domain.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionSystemException;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@Testcontainers
@RunWith(SpringRunner.class)
public class ProductValidationFailedTest {

    private Product product;

    @Autowired
    ProductRepository productRepository;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Rule
    public PostgreSQLContainer<?> postgresContainer =
            new PostgreSQLContainer<>("postgres:latest");

    @Test
    void saveProductWithoutArticleNumberThrowsValidationError(){
        product = Product.builder()
                .articleName("Test")
                .price(13.3)
                .producer("Apple")
                .stock(2)
                .categories(Category.TECH)
                .build();


        assertThrows(JpaSystemException.class, () -> {
            productRepository.saveOrUpdateProduct(product);
        } );
    }

    @Test
    void saveProductWithoutArticleNameThrowsValidationError() throws Exception {
        product = Product.builder()
                .articleNumber(544695585556554L)
                .price(13.3)
                .producer("Apple")
                .stock(2)
                .categories(Category.TECH)
                .build();

        assertThrows(TransactionSystemException.class, () -> {
            productRepository.saveOrUpdateProduct(product);
        } );
    }

    @Test
    void saveProductWithoutPriceThrowsValidationError() throws Exception {
        product = Product.builder()
                .articleNumber(544695585556554L)
                .articleName("Test")
                .producer("Apple")
                .stock(2)
                .categories(Category.TECH)
                .build();

        assertThrows(TransactionSystemException.class, () -> {
            productRepository.saveOrUpdateProduct(product);
        } );
    }

    @Test
    void saveProductWithoutProducerThrowsValidationError() throws Exception {
        product = Product.builder()
                .articleNumber(544695585556554L)
                .articleName("Test")
                .price(13.3)
                .stock(2)
                .categories(Category.TECH)
                .build();

        assertThrows(TransactionSystemException.class, () -> {
            productRepository.saveOrUpdateProduct(product);
        } );
    }

    @Test
    void saveProductWithoutStockThrowsValidationError() throws Exception {
        product = Product.builder()
                .articleNumber(544695585556554L)
                .articleName("Test")
                .price(13.3)
                .producer("Apple")
                .categories(Category.TECH)
                .build();

        assertThrows(TransactionSystemException.class, () -> {
            productRepository.saveOrUpdateProduct(product);
        } );
    }

    @Test
    void saveProductWithoutCategoryThrowsValidationError() throws Exception {
        product = Product.builder()
                .articleNumber(544695585556554L)
                .articleName("Test")
                .price(13.3)
                .producer("Apple")
                .stock(2)
                .build();

        assertThrows(TransactionSystemException.class, () -> {
            productRepository.saveOrUpdateProduct(product);
        } );
    }
}
