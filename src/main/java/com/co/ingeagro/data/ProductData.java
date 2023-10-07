package com.co.ingeagro.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "product")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductData {

    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column
    private BigDecimal price;
    @OneToOne(cascade = {CascadeType.ALL})
    private StockData stock;
    @OneToOne()
    private QuantityTypeData quantityType;
    @Column
    private String description;
    @OneToOne()
    private ProductTypeData productType;
    @Column
    private LocalDateTime timeCreation;
    private Boolean active;
    @Column
    private Double lat;
    @Column
    private Double lng;

}
