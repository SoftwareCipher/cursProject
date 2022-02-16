package com.company;

public class Person {
    private int phoneNumber;
    private String fio;
    private String email;

    public Person(String fio, String email, int phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.fio = fio;
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getFio() {
        return fio;
    }

    public String getEmail() {
        return email;
    }
}
