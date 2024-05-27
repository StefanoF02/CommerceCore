package com.commercecore.it.products;

import com.commercecore.domain.entity.Product;
import com.commercecore.domain.repository.ProductRepository;
import com.commercecore.it.factories.ProductFactory;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

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
    public PostgreSQLContainer<?> postgresContainer =
            new PostgreSQLContainer<>("postgres:latest");

    @Test
    void saveAndRetrieveProductTest(){
        //Arrange
        product = ProductFactory.buildFullProduct();
        productRepository.saveOrUpdateProduct(product);

        //Act
        var retrievedProduct = productRepository.findByArtNumber(product.getArticleNumber());

        //Assert
        assertEquals(product, retrievedProduct.get());

    }

}
