package com.co.ingeagro.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table (name = "cart")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartData {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<SellProductData> products;
    @ManyToOne()
    private BuyerData user;
    @Column
    private Boolean bought;

}