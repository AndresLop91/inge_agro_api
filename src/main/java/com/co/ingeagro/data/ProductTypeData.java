package com.co.ingeagro.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "product_type")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductTypeData {

    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column
    private String name;
}
