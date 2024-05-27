package com.commercecore.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Product {
    @Valid

    @Id
    @Range(min = 100000000000000L,
            max = 999999999999999999L,
            message = "Article number must be at least 15 and a maximum of 19 numbers long.")
    @NotNull(message = "Article numberg must not be null.")
    private Long articleNumber;

    @NotBlank(message = "Article name must not be blank.")
    @NotNull(message = "Article name must not be null.")
    private String articleName;


    @NotNull(message = "Price must not be null.")
    private Double price;

    @NotBlank(message = "Producer must not be blank.")
    @NotNull
    private String producer;

    @Range(min = 1, message = "Stock must be at least 1.")
    @NotNull(message = "Stock must not be null.")
    private Integer stock;

    @NotNull(message = "Stock must not be null.")
    @Enumerated(EnumType.STRING)
    private Category categories;

    @NotNull(message = "Currency must not be null")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "product")
    private Collection<Review> reviews = new ArrayList<>();

}
