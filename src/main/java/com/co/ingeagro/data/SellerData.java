package com.co.ingeagro.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "seller")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SellerData {

    @Id
    @GeneratedValue
    @Column
    private Long id;
    @OneToOne
    private UserData user;
    @OneToMany(cascade = {CascadeType.ALL})
    List<ProductData> products;
    @Column
    private LocalDateTime timeCreation;
}
