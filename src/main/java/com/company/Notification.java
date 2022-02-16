package com.company;

public class Notification {
    private String text;
    private String status;

    public Notification(String text, String status) {
        this.text = text;
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public String getStatus() {
        return status;
    }

}
