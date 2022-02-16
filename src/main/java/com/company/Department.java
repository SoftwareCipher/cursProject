package com.company;

public class Department {
    private int id;
    private String desc;

    public Department(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }
}
