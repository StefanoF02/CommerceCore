package com.commercecore.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Review {

    @Id
    @NonNull
    private Integer id;

    @NonNull
    private Product product;

    @NonNull
    private Integer rating;

    private String comment;

    @NonNull
    private LocalDate reviewDate;
}
