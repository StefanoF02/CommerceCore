package com.commercecore.it.factories;

import com.commercecore.domain.entity.enums.Category;
import com.commercecore.domain.entity.enums.Currency;
import com.commercecore.domain.entity.Product;

public class ProductFactory {

    public static Product buildFullProduct(){

        return Product.builder()
                .articleNumber(544695585556554L)
                .articleName("MacBook Pro")
                .price(1299.99)
                .producer("Apple")
                .currency(Currency.EURO)
                .stock(2)
                .categories(Category.TECH)
                .build();
    }
}
