package com.co.ingeagro.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserData {

    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column
    private String username;
    @Column
    private String password;
    @OneToOne(cascade = {CascadeType.ALL})
    private PersonData person;
    @Column
    private LocalDateTime timeCreation;
    @Column
    private LocalDateTime timeModification;

}
