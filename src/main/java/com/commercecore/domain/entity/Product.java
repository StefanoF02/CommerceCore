package com.commercecore.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {

    @Id
    private Long articleNumber;
    //@Range(min = 100000000, max = 999999999, message = "Article number must be between 100000000 and 999999999.")

    @NonNull
    private String articleName;

    @NonNull
    private Double price;

    @NonNull
    //@Size(min = 1, max = 9999)
    private String producer;

    @NonNull
    private Integer stock;

    @NonNull
    private Set<Category> categories;

    private List<Review> reviews;

}
