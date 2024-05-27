package com.commercecore.api.mapper;

import com.commercecore.api.model.ProductAo;
import com.commercecore.domain.entity.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    public ProductAo toApi(Product product);

    public Product toDomain(ProductAo productAo);
}
