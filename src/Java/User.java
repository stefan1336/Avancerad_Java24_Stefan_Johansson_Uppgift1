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
        System.out.println("Add car to rent method");
    }

    public void addCarRentalCost(int cost) {
        carCost += cost;
    }

    public int totalCost() {
        return carCost;
    }

    @Override
    public void rentCar(String car) {
        System.out.println("This is som information about your car: " + car);
    }

    @Override
    public void returnCar(String car) {
        System.out.println("You just returned: " + car);
    }

    @Override
    public void carCost(String car) {
        System.out.println("The price for your car is multiplied by the days you are renting it for");
    }

    @Override
    public void driveCar(String car) {
        System.out.println("You just drive for: " + car);
    }

    @Override
    public String getCarType() {
        return "";
    }

}

// Spara som ett kvitto i en textfil om informationen om den hyrda bilen
