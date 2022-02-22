package com.company.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor

public class Package {
    private long id;
    private String senderName;
    private String senderDepart;
    private String recipientDepart;
    private int recipientPhoneNumber;
    private String recipientName;
    private String status;
    private LocalDateTime dateCreation;
    private LocalDateTime dateChange;
}
