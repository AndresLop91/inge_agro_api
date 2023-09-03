package com.co.ingeagro.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {

    private Long id;
    private List<SellProduct> products;
    private Buyer user;
    private Boolean bought;

}
