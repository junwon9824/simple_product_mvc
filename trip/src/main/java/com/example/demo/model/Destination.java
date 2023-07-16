package com.example.demo.model;

public class Destination {
    private int id;
    private String name;
    private String description;
    private String region;
    private double price;

    public Destination() {
        // 기본 생성자
    }

    public Destination(int id, String name, String description, String region, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.region = region;
        this.price = price;
    }

    // Getter 및 Setter 메서드
    // ...

    // toString 메서드
    // ...
}
