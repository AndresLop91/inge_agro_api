package com.co.ingeagro.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "stock")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockData {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private Integer initialQuantity;
    @Column
    private Integer soldQuantity;
    @Column
    private Integer remainingQuantity;
    @Column
    private LocalDateTime timeCreation;

}
