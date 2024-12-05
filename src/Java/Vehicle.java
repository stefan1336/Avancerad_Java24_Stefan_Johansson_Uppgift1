package Java;

import Java.Interface.Rentable;

import java.util.Scanner;

public abstract class Vehicle implements Rentable {
    private String brand;
    private String registerNumber;
    private int price;

    Scanner scanner = new Scanner(System.in);

    public Vehicle(String brand, String registerNumber, int price) {
        this.brand = brand;
        this.registerNumber = registerNumber;
        this.price = price;
    }

    public abstract void showCarDetails();


    @Override
    public void rentCar(String car) {
        System.out.println("Car information, " + car);
    }

    @Override
    public void returnCar(Vehicle vehicle, int totalcost, int carRentingDays) {
        System.out.println("Now its time for you to return your car, do you want a receipt? y/n");
        String userInput = scanner.nextLine();
        try{
            if(userInput.equalsIgnoreCase("y")){
                createReceipt(vehicle, totalcost, carRentingDays);
            }
            else{
                System.out.println("Thanks for choosing Grit Academys Car Shop");
                System.out.println("Good bye and welcome back");
            }
        } catch (Exception e) {
            System.out.println("Please answer if you want an receipt or not");
            throw new RuntimeException(e);
        }
    }

    private void createReceipt(Vehicle vehicle, int totalcost, int carRentingDays) {
        VehicleController vehicleController = new VehicleController();
        vehicleController.printReceipt(vehicle,totalcost, carRentingDays);
    }

    @Override
    public void carCost(String car) {
        System.out.println("Your car cost: " + car);
    }

    @Override
    public void driveCar(String car){

        String carType = this.getCarType();

        if(carType.equalsIgnoreCase("Convertible")){
            System.out.println("The type of car you have rented is a " + carType);
            System.out.println("You just drove a " + car + " WROOOOM i feel like a Hoolywood Star");
        }
        else if(carType.equalsIgnoreCase("Electric")){
            System.out.println("The type of car you have rented is a " + carType);
            System.out.println("You just drove a " + car + " WROOOOM im doing something good for the climate");
        }
        else if(carType.equalsIgnoreCase("Limousine")){
            System.out.println("The type of car you have rented is a " + carType);
            System.out.println("You just drove a " + car + " WROOOOM im so rich!");
        }
    }

    @Override
    public String toString() {
        return " Brand: " + this.getBrand() + ", Reg-No: " + this.getRegisterNumber() + ", Price: " + this.getPrice() + " kr";
    }

    public String getBrand() {
        return brand;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public int getPrice() {
        return price;
    }

}


