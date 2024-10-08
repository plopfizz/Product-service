package com.productmicroservice.product.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "categories")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Category {
    @Id
    private String id;
    @NotNull(message = "Category cannot be null")
    private String name;
}
