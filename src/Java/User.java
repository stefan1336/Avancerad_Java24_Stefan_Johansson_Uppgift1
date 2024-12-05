package Java;

import Java.Interface.Rentable;

import java.util.ArrayList;
import java.util.List;

public class User implements Rentable {
    private int carCost;
    private List<Vehicle> rentedCar;

    public User() {
        this.carCost = 0;
        this.rentedCar = new ArrayList<>();
    }

    public void addCarToRent(Vehicle car){
        rentedCar.add(car);
        carCost += car.getPrice();
    }

    public void addCarRentalCost(int cost) {
        carCost += cost;
    }

    @Override
    public void rentCar(String car) {
        System.out.println("This is som information about your car: " + car);
    }

    @Override
    public void returnCar(Vehicle vehicle, int totalCost, int carRentingDays) {
        System.out.println("You just returned: " + vehicle.toString());
    }

    @Override
    public void carCost(String car) {
        System.out.println("The price for your car is multiplied by the days you are renting it for");
    }

    @Override
    public void driveCar(String car) {
        System.out.println("You just drove for: " + car);
    }

    @Override
    public String getCarType() {
        return "";
    }
}

