package com.ch07.entity.shop;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
@Table(name = "shop_product")
public class Product {

    @Id
    private int productId;
    private String productName;
    private int price;
    private int stock;


}
