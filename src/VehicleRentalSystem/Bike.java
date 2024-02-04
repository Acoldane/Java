package Day6.VehicleRentalSystem;

public class Bike extends Vehicle{
    int yearMade;

    public Bike(String make, String model, double rentalPrice, int yearMade) {
        super(make, model, rentalPrice);
        this.yearMade = yearMade;
    }

    public int getYearMade() {
        return yearMade;
    }

    public void setYearMade(int yearMade) {
        this.yearMade = yearMade;
    }
}
