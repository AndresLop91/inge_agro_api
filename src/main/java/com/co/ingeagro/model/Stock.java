package com.co.ingeagro.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

    private Long id;
    private Integer initialQuantity;
    private Integer soldQuantity;
    private Integer remainingQuantity;
    private LocalDateTime timeCreation;

}
