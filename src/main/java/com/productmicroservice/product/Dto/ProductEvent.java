package com.productmicroservice.product.Dto;


import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class ProductEvent  {
    private String actionType;
    private String productId;

}
