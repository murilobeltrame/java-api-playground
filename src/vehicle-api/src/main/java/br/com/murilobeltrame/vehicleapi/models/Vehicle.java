package br.com.murilobeltrame.vehicleapi.models;

import java.util.Date;

public class Vehicle {
    private final String licensePlate;
    private final String brand;
    private final String model;
    private final Date createdAt;

    public Vehicle(String licensePlate, String brand, String model) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.createdAt = new Date();
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
