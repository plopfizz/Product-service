package com.productmicroservice.product.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "product")
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private int price;
    private Date createdAt;
    private Date updatedAt;
    private Boolean isAvailable;
    private Category category;
    private List<String> attributes;
    private List<String> imageUrls;

    private Double averageRating;
    private Integer totalReviews;



}
