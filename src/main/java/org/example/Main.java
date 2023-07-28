package org.example;

// Main class for testing the parking lot
public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(3, 10, 5);

        Vehicle vehicle1 = new Vehicle("ABC123", "Car");
        Vehicle vehicle2 = new Vehicle("XYZ789", "Motorcycle");
        Vehicle vehicle3 = new Vehicle("ABC125", "Car");
        parkingLot.parkVehicle(vehicle1);
        parkingLot.parkVehicle(vehicle2);
        parkingLot.parkVehicle(vehicle3);

        parkingLot.removeVehicle(vehicle1);
    }
}