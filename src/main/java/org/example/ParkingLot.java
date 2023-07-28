package org.example;

// ParkingLot class to manage the overall parking lot
class ParkingLot {
    private int numFloors;
    private ParkingFloor[] floors;

    public ParkingLot(int numFloors, int carSlotsPerFloor, int motorcycleSlotsPerFloor) {
        this.numFloors = numFloors;
        this.floors = new ParkingFloor[numFloors];
        initializeFloors(carSlotsPerFloor, motorcycleSlotsPerFloor);
    }

    private void initializeFloors(int carSlotsPerFloor, int motorcycleSlotsPerFloor) {
        for (int i = 0; i < numFloors; i++) {
            floors[i] = new ParkingFloor(i + 1, carSlotsPerFloor, motorcycleSlotsPerFloor);
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            ParkingSlot slot = floor.findAvailableSlot(vehicle);
            if (slot != null) {
                slot.parkVehicle(vehicle);
                System.out.println("Vehicle with registration number " + vehicle.getRegistrationNumber() + " parked at Floor " + floor.getFloorNumber() + ", Slot " + slot.getSlotNumber());
                return true;
            }
        }
        System.out.println("Sorry, no available slots for this vehicle type.");
        return false;
    }

    public boolean removeVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            for (ParkingSlot slot : floor.getCarSlots()) {
                if (!slot.isAvailable() && slot.getVehicle().equals(vehicle)) {
                    slot.removeVehicle();
                    System.out.println("Vehicle with registration number " + vehicle.getRegistrationNumber() + " removed from Floor " + floor.getFloorNumber() + ", Slot " + slot.getSlotNumber());
                    return true;
                }
            }

            for (ParkingSlot slot : floor.getMotorcycleSlots()) {
                if (!slot.isAvailable() && slot.getVehicle().equals(vehicle)) {
                    slot.removeVehicle();
                    System.out.println("Vehicle with registration number " + vehicle.getRegistrationNumber() + " removed from Floor " + floor.getFloorNumber() + ", Slot " + slot.getSlotNumber());
                    return true;
                }
            }
        }
        System.out.println("Vehicle not found in the parking lot.");
        return false;
    }
}
