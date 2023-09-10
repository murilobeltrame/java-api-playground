package br.com.murilobeltrame.vehicleapi.models;

public class VehicleCreateRequest extends VehicleUpdateRequest {
    private final String licensePlate;

    public VehicleCreateRequest (String licensePlate, String brand, String model) {
        super(brand, model);
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}