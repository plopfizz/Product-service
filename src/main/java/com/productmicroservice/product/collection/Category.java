package com.productmicroservice.product.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
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
    private Long id;
    private String name;
}
