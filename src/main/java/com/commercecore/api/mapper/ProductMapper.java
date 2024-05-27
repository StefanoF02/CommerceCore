package com.commercecore.api.mapper;

import com.commercecore.api.model.ProductAo;
import com.commercecore.domain.entity.Product;
import com.commercecore.domain.entity.enums.Category;
import com.commercecore.domain.entity.enums.Currency;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    public ProductAo toApi(Product product);

    public Product toDomain(ProductAo productAo);

    default String toApi(Category category){
        return category.category;
    }

    default Category categoryToDomain(String category){return Category.valueOf(category);}

    default String toApi(Currency currency){
        return currency.currency;
    }

    default Currency currencyToDomain(String currency){return Currency.valueOf(currency);}

    default String producerToApi(String producer){
        return capitalizeWords(producer);

    }

    private static String capitalizeWords(String input) {
        // split the input string into an array of words
        String[] words = input.split("\\s");

        // StringBuilder to store the result
        StringBuilder result = new StringBuilder();

        // iterate through each word
        for (String word : words) {
            // capitalize the first letter, append the rest of the word, and add a space
            result.append(Character.toTitleCase(word.charAt(0)))
                    .append(word.substring(1))
                    .append(" ");
        }

        // convert StringBuilder to String and trim leading/trailing spaces
        return result.toString().trim();
    }
}
