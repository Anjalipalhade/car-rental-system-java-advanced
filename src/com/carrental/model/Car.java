package com.carrental.model;

public class Car {
    private int carId;
    private String model;
    private boolean available;

    public Car(int carId, String model, boolean available) {
        this.carId = carId;
        this.model = model;
        this.available = available;
    }

    public int getCarId() { return carId; }
    public String getModel() { return model; }
    public boolean isAvailable() { return available; }
}
