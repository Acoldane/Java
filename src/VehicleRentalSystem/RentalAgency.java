package Day6.VehicleRentalSystem;

import java.util.ArrayList;

public class RentalAgency {
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Vehicle> RentVehicles;


    public RentalAgency() {
        this.vehicles = new ArrayList<>();
        this.RentVehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void rentVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);

        RentVehicles.add(vehicle);
    }

    public void display() {
        System.out.println("Vehicle Contents:");
        for (Vehicle v : vehicles) {
            if (v instanceof Car) {
                Car c = (Car) v;
                System.out.println("Make : " + c.make + " Model : " + c.model + " rentalPrice : " + c.rentalPrice + " speed : " + c.speed);
            } else if (v instanceof Bike) {
                Bike b = (Bike) v;
                System.out.println("Make : " + b.make + " Model : " + b.model + " rentalPrice : " + b.rentalPrice + " Year : " + b.yearMade);

            } else {
                System.out.println("Make : " + v.make + " Model : " + v.model + " rentalPrice : " + v.rentalPrice);
            }
        }
    }

    public void showAllRentVehicles() {
        System.out.println("List of rented vehicles:");

        for (Vehicle v : RentVehicles) {
            if (v instanceof Car) {
                Car c = (Car) v;
                System.out.println("Make : " + c.make + " Model : " + c.model + " rentalPrice : " + c.rentalPrice + " speed : " + c.speed);
            } else if (v instanceof Bike) {
                Bike b = (Bike) v;
                System.out.println("Make : " + b.make + " Model : " + b.model + " rentalPrice : " + b.rentalPrice + " Year : " + b.yearMade);

            } else {
                System.out.println("Make : " + v.make + " Model : " + v.model + " rentalPrice : " + v.rentalPrice);
            }
        }

    }
}
