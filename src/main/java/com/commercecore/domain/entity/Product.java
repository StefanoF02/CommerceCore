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

    @NonNull
    private String articleName;

    @NonNull
    private Double price;

    @NonNull
    private String producer;

    @NonNull
    private Integer stock;

    @NonNull
    private Set<Category> categories;

    private List<Review> reviews;

}
