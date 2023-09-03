package com.co.ingeagro.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "buyer")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuyerData {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private Boolean isGuest;
    @OneToOne
    private UserData user;
    @OneToOne
    private GuestUserData guestUser;
    @Column
    private LocalDateTime creationTime;

}
