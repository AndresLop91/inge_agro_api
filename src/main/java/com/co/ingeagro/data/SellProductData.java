package com.co.ingeagro.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "sell_product")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellProductData {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private Integer quantity;
    @OneToOne
    private ProductData product;
}
