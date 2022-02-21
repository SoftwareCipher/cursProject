package com.company.entities;

import java.time.LocalDateTime;

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

    public Package(long id, String senderName, String senderDepart, String recipientDepart, int recipientPhoneNumber,
                   String recipientName, String status, LocalDateTime dateCreation, LocalDateTime dateChange) {
        this.id = id;
        this.senderName = senderName;
        this.senderDepart = senderDepart;
        this.recipientDepart = recipientDepart;
        this.recipientPhoneNumber = recipientPhoneNumber;
        this.recipientName = recipientName;
        this.status = status;
        this.dateCreation = dateCreation;
        this.dateChange = dateChange;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getSenderDepart() {
        return senderDepart;
    }

    public String getRecipientDepart() {
        return recipientDepart;
    }

    public int getRecipientPhoneNumber() {
        return recipientPhoneNumber;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public LocalDateTime getDateChange() {
        return dateChange;
    }
}
