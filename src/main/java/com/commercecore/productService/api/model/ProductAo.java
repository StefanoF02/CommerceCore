package com.commercecore.productService.api.model;

import com.commercecore.productService.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductAo {

    private Long articleNumber;

    private String articleName;

    private Double price;

    private String producer;

    private Integer stock;

    private String categories;

    private String currency;

    private Collection<Review> reviews;
}
