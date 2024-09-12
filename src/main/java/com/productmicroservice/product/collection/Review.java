package com.productmicroservice.product.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "review")
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Review {
    @Id
    private String id;
    private String productId;  // Reference to Product
    private String reviewerName;
    private String comment;
    private Double rating;
}
