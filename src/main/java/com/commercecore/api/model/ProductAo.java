package com.commercecore.api.model;

import com.commercecore.domain.entity.Review;
import com.commercecore.domain.entity.enums.Category;
import com.commercecore.domain.entity.enums.Currency;
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

    private Category categories;

    private Currency currency;

    private Collection<Review> reviews;
}
