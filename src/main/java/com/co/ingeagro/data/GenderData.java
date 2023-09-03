package com.co.ingeagro.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "Gender")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenderData {

    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column
    private String genderName;
}
