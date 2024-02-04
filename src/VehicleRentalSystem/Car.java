package Day6.VehicleRentalSystem;

public class Car extends Vehicle{
    int speed;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Car(String make, String model, double rentalPrice, int speed) {
        super(make, model, rentalPrice);
        this.speed = speed;
    }
}
