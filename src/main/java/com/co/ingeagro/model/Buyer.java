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
public class Buyer {

    private Long id;
    private Boolean isGuest;
    private User user;
    private GuestUser guestUser;
    private LocalDateTime timeCreation;

}
