package com.commercecore.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.Range;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {
    @Valid

    @Id
    @Range(min = 100000000000000L,
            max = 999999999999999999L,
            message = "Article number must be at least 15 and a maximum of 19 numbers long.")
    @NotNull(message = "Article numberg must not be null.")
    private Long articleNumber;

    @NonNull
    @NotBlank(message = "Article name must not be blank.")
    @NotNull(message = "Article name must not be null.")
    private String articleName;


    @NotNull(message = "Price must not be null.")
    private Double price;

    @NotBlank(message = "Producer must not be blank.")
    @NonNull
    //@Size(min = 1, max = 9999)
    private String producer;

    @Range(min = 1, message = "Stock must be at least 1.")
    @NotNull(message = "Stock must not be null.")
    private Integer stock;

    @NotNull(message = "Stock must not be null.")
    @Enumerated(EnumType.STRING)
    private Category categories;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews = new ArrayList<>();

}
