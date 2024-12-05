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

    // Metod som är tom då den bara används i User
    @Override
    public void rentCar(Vehicle vehicle, int totalCost, int carRentingDays) {
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
            displayConvertible(car,carType);
        }
        else if(carType.equalsIgnoreCase("Electric")){
            displayElectric(car,carType);
        }
        else if(carType.equalsIgnoreCase("Limousine")){
            displayLimousine(car,carType);
        }
    }

    private void displayConvertible(String car, String carType){
        System.out.println("The type of car you have rented is a " + carType);

        System.out.println("                              _.-=\"_-         _");
        System.out.println("                         _.-=\"   _-          | ||\"\"\"\"\"\"\"---._______     __..");
        System.out.println("             ___.===\"\"\"\"-.______-,,,,,,,,,,,,`-''----\" \"\"\"\"\"       \"\"\"\"\"  __'");
        System.out.println("      __.--\"\"     __        ,'                   o \\           __        [__|");
        System.out.println(" __-\"\"=======.--\"\"  \"\"--.=================================.--\"\"  \"\"--.=======:");
        System.out.println("]       [w] : /        \\ : |========================|    : /        \\ :  [w] :");
        System.out.println("V___________:|          |: |========================|    :|          |:   _-\"");
        System.out.println(" V__________: \\        / :_|=======================/_____: \\        / :__-\"");
        System.out.println(" -----------'  \"-____-\"  `-------------------------------'  \"-____-\"");

        System.out.println("You just drove a " + car + " YEAAAH i feel like a Hoolywood Star");
    }

    private void displayElectric(String car, String carType){
        System.out.println("The type of car you have rented is a " + carType);

        System.out.println("                       ____________________");
        System.out.println("                     //|           |        \\");
        System.out.println("                   //  |           |          \\");
        System.out.println("      ___________//____|___________|__________()\\__________________");
        System.out.println("    /__________________|_=_________|_=___________|_________________{}");
        System.out.println("    [           ______ |           | .           | ==  ______      { }");
        System.out.println("  __[__        /##  ##\\|           |             |    /##  ##\\    _{# }_");
        System.out.println(" {_____)______|##    ##|___________|_____________|___|##    ##|__(______}");
        System.out.println("             /  ##__##                              /  ##__##        \\");
        System.out.println("----------------------------------------------------------------------------");

        System.out.println("You just drove a " + car + " WROOOOM im doing something good for the climate");
    }

    private void displayLimousine(String car, String carType){

        System.out.println("The type of car you have rented is a " + carType);

        System.out.println("     ___________________________     |");
        System.out.println("  _ /   ___/~~~    /------------\\    |");
        System.out.println("_|_/_______________|______|____|__\\__|________,_");
        System.out.println("\\ _________________|____-_|-______|_____________)");
        System.out.println("<____//   \\|______|______|_______|_//   \\)_____>");
        System.out.println("      \\___/                         \\___/");

        System.out.println("You had a blast in a " + car + " WROOOOM im so rich!");

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


