package com.commercecore.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @NonNull
    private Integer id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @NonNull
    private Integer rating;

    private String comment;

    @NonNull
    private LocalDate reviewDate;
}
