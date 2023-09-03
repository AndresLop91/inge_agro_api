package com.co.ingeagro.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "guest_user")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuestUserData {

    @Id
    @GeneratedValue
    @Column
    private Long id;
    @OneToOne
    private PersonData person;

}
