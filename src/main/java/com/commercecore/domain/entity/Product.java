package com.commercecore.domain.entity;

import com.commercecore.domain.entity.enums.Category;
import com.commercecore.domain.entity.enums.Currency;
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
@Table(name = "products")
public class Product {
    @Valid

    @Id
    @Range(min = 100000000000000L,
            max = 999999999999999999L,
            message = "Article number must be at least 15 and a maximum of 19 numbers long.")
    @NotNull(message = "Article number must be set.")
    private Long articleNumber;

    @NotBlank(message = "Article name must be set.")
    private String articleName;


    @NotNull(message = "Price must be set.")
    private Double price;

    @NotBlank(message = "Producer must be set.")
    private String producer;

    @Range(min = 1, message = "Stock must be at least 1.")
    @NotNull(message = "Stock must be set.")
    private Integer stock;

    @NotNull(message = "Stock must be set.")
    @Enumerated(EnumType.STRING)
    private Category categories;

    @NotNull(message = "Currency must be set.")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "product")
    @Builder.Default
    private Collection<Review> reviews = new ArrayList<>();

}
