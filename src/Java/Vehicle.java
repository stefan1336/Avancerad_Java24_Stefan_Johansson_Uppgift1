package Java;

import Java.Interface.Rentable;

public abstract class Vehicle implements Rentable {
    private String brand;
    private String registerNumber;
    private int price;

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
    public void returnCar(String car) {
        System.out.println("You just returned: " + car);
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
            System.out.println("You just drove a " + car + " WROOOOM");
        }
        else if(carType.equalsIgnoreCase("Electric")){
            System.out.println("Polestar");
            System.out.println("You just drove a " + car + " WROOOOM");
        }
        else if(carType.equalsIgnoreCase("Limousine")){
            System.out.println("Limousine");
            System.out.println("You just drove a " + car + " WROOOOM");
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


