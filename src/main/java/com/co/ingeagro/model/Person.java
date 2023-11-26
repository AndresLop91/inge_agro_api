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
public class Person {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDateTime bornDate;
    private String identificationNumber;
    private IdentificationType identificationType;
    private Gender gender;
    private String phoneNumber;
    private LocalDateTime timeCreation;

}
