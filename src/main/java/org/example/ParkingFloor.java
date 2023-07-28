package org.example;

// ParkingFloor class to represent a floor in the parking lot
class ParkingFloor {
    private int floorNumber;
    private ParkingSlot[] carSlots;
    private ParkingSlot[] motorcycleSlots;

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public ParkingSlot[] getCarSlots() {
        return carSlots;
    }

    public void setCarSlots(ParkingSlot[] carSlots) {
        this.carSlots = carSlots;
    }

    public ParkingSlot[] getMotorcycleSlots() {
        return motorcycleSlots;
    }

    public void setMotorcycleSlots(ParkingSlot[] motorcycleSlots) {
        this.motorcycleSlots = motorcycleSlots;
    }

    public ParkingFloor(int floorNumber, int carSlotsCount, int motorcycleSlotsCount) {
        this.floorNumber = floorNumber;
        this.carSlots = new ParkingSlot[carSlotsCount];
        this.motorcycleSlots = new ParkingSlot[motorcycleSlotsCount];
        initializeSlots(carSlotsCount, motorcycleSlotsCount);
    }

    private void initializeSlots(int carSlotsCount, int motorcycleSlotsCount) {
        for (int i = 0; i < carSlotsCount; i++) {
            carSlots[i] = new ParkingSlot(i + 1, "Car");
        }

        for (int i = 0; i < motorcycleSlotsCount; i++) {
            motorcycleSlots[i] = new ParkingSlot(i + 1, "Motorcycle");
        }
    }

    public ParkingSlot findAvailableSlot(Vehicle vehicle) {
        ParkingSlot[] slots = vehicle.getVehicleType().equals("Car") ? carSlots : motorcycleSlots;

        for (ParkingSlot slot : slots) {
            if (slot.isAvailable()) {
                return slot;
            }
        }
        return null;
    }
}