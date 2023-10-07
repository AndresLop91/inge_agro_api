package com.co.ingeagro.model;

import com.co.ingeagro.data.ProductTypeData;
import com.co.ingeagro.data.QuantityTypeData;
import com.co.ingeagro.data.StockData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Long id;
    private BigDecimal price;
    private Stock stock;
    private QuantityType quantityType;
    private String description;
    private ProductType productType;
    private LocalDateTime timeCreation;
    private Boolean active;
    private Double lat;
    private Double lng;
}
