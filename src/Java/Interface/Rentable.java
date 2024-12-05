package Java.Interface;

import Java.Vehicle;

public interface Rentable {
    public void rentCar(String vehicle);
    public void returnCar(Vehicle vehicle, int totalCost, int carRentingDays);
    public void carCost(String vehicle);
    public void driveCar(String vehicle);
    public String getCarType();
}