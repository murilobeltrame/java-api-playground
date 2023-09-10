package br.com.murilobeltrame.vehicleapi.models;

public class VehicleResponse extends Vehicle{
    public VehicleResponse(String licensePlate, String brand, String model) {
        super(licensePlate, model, brand);
    }

    public static VehicleResponse from(VehicleCreateRequest request) {
        return new VehicleResponse(request.getLicensePlate(), request.getBrand(), request.getModel());
    }
}
