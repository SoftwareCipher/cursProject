package com.company.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Person {
    private String fio;
    private String email;
    private int phoneNumber;
}
