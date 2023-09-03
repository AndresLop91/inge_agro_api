package com.co.ingeagro.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "person")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonData {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private LocalDateTime bornDate;
    @Column
    private String identificationNumber;
    @OneToOne(cascade = {CascadeType.MERGE})
    private IdentificationTypeData identificationType;
    @OneToOne(cascade = {CascadeType.MERGE})
    private GenderData gender;
    @Column
    private LocalDateTime timeCreation;

}

