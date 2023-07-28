package org.example;

// ParkingSlot class to represent individual parking slots
class ParkingSlot {
    private int slotNumber;
    private String vehicleType;
    private boolean isAvailable;
    private Vehicle vehicle;

    public ParkingSlot(int slotNumber, String vehicleType) {
        this.slotNumber = slotNumber;
        this.vehicleType = vehicleType;
        this.isAvailable = true;
        this.vehicle = null;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isAvailable = false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isAvailable = true;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
