package br.com.murilobeltrame.vehicleapi.models;

public class VehicleUpdateRequest {
    private final String brand;
    private final String model;

    public VehicleUpdateRequest(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}
