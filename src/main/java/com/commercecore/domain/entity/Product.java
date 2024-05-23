package com.commercecore.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {

    @Id
    //@Range(min = 100000000, max = 999999999, message = "Article number must be between 100000000 and 999999999.")
    private Integer articleNumber;

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
    @Enumerated(EnumType.STRING)
    private Category categories;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

}
