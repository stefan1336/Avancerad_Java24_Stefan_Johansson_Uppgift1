package Java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

public class VehicleController {
    Scanner scanner = new Scanner(System.in);
    private String carType = "";
    private int carRentingDays;
    private int totalCost;

    private Garage garage;
    private User user;
    private Vehicle vehicle;

    public VehicleController(){
        this.garage = new Garage();
        this.user = new User();
        fillGarage();
    }

    // Metod för att skapa bilarna och placerar dom i min garageklass
    private void fillGarage() {
        garage.addVehicle("Limousine",new Limousine("Volvo","NMN 123",10000,7,"Stefan Jr"));
        garage.addVehicle("Limousine",new Limousine("Nissan", "RMX 448", 5000, 5,"Per Johansson"));
        garage.addVehicle("Limousine",new Limousine("Saab","TFK 139",1000,2,"Folke Svahn"));
        garage.addVehicle("Convertible",new Convertible("Ferrari","XXX 333",200000,false));
        garage.addVehicle("Convertible",new Convertible("Lamborgini","FTW $$$",20000000,false));
        garage.addVehicle("Electric",new Electric("Nio","MAG 840",40000, 10));
        garage.addVehicle("Electric",new Electric("Polestar","IAS 219",20300, 20));
        garage.addVehicle("Electric",new Electric("Tesla","TLW 714",105000, 30));
    }

    public void welcomeCustomer(){
        System.out.println("    ____");
        System.out.println(" __/  |_\\_");
        System.out.println("|  _     _``-.");
        System.out.println("'-(_)---(_)--'");
        System.out.println("------------------- Do you want to see our cars? y/n ----------------------");
        startShopping();
        scanner.close();
    }

    // Metod där användaren kan välja att hyra bil eller inte
    private void startShopping(){
        String userAnswer = scanner.nextLine();
        if(userAnswer.equalsIgnoreCase("y")){
            displayCarOptions();
        }
        else if(userAnswer.equalsIgnoreCase("n")){
            System.out.println("Goodbye and welcome again another time");
        }
        else{
            System.out.println("Sorry I cant understand what you're saying, im asking you again");
            welcomeCustomer();
        }
    }

    // Metod för att visa alla olika typer av biler som finns
    private void displayCarOptions() {
        System.out.println("------------------ Car Options--------------------");
        System.out.println("Type the number of the different Car opinons you're intressted in");
        System.out.println("1. Convertible");
        System.out.println("2. Electric");
        System.out.println("3. Limousine");

        String userInput = scanner.nextLine();

        switch(userInput){
            case "1":
                carType = "Convertible";
                break;
            case "2":
                carType = "Electric";
                break;
            case "3":
                carType = "Limousine";
                break;
                default:
                break;
        }
        getCars(carType);
    }
    
    private void getCars(String carType) {
        List<Vehicle> vehicleList = garage.getVehicle(carType);
        if(vehicleList.isEmpty()){
            System.out.println("No cars found");
            displayCarOptions();
        }
        else{
            displayVehicleList(vehicleList);
            String userInput = scanner.nextLine();
            if(userInput.equalsIgnoreCase("back")){
                displayCarOptions();
            }
            else{
               displayChosenCars(userInput, vehicleList);
            }
        }
    }

    // Metod för att displaya de olika typerna av bilar som finns i en lista där varje bil får ett nummer tilldelat
    private void displayVehicleList(List<Vehicle>vehicleList){
        System.out.println("Those cars are available for this category: ");
        for(int i = 0; i < vehicleList.size(); i++){
            System.out.println((i+1)+". " + vehicleList.get(i).toString());
        }
        System.out.println("If you want any of those cars please enter the number of the car you want or type back if you want to see the other car types");
    }

    // Metod för att visa den valda bilen
    private void displayChosenCars(String userInput, List<Vehicle> vehicleList){
        try{
            int carNumber = Integer.parseInt(userInput) -1;
            if(carNumber >= 0 && carNumber < vehicleList.size()){
                vehicle = vehicleList.get(carNumber);
                displayCarFunctions(vehicle);
                vehicle.showCarDetails();
                daysToRent();
            }
            else{
                System.out.println("Cant find the car you're looking for, please choose another car");
                getCars(carType);
            }
        }
        catch(NumberFormatException e){
            System.out.println("Please enter a number");
            getCars(carType);
        }
    }

    // Metod där varje specifik bilsort har en egen metod som ger användaren olika valmöjligheter
    private void displayCarFunctions(Vehicle vehicle){
        if(vehicle.getCarType().equals("Convertible")){
            Convertible convertible = (Convertible) vehicle;
            convertible.decideRoof();
        }
        else if(vehicle.getCarType().equals("Electric")){
            Electric electric = (Electric) vehicle;
            electric.chargeCar();
        } else if (vehicle.getCarType().equals("Limousine")) {
            Limousine limousine = (Limousine) vehicle;
            limousine.specialTreatment();
        }
    }

    // Metod där användaren får välja hur många dagar den ska hyra bilen
    private void daysToRent(){
        try{
            user.carCost(vehicle.toString());
            System.out.println("For how manny days do you want to rent the car?");
            carRentingDays = Integer.parseInt(scanner.nextLine());
            if(carRentingDays > 0){
                totalCost = vehicle.getPrice() * carRentingDays;
                user.addCarRentalCost(totalCost);
                user.addCarToRent(vehicle);
                garage.getVehicle(carType).remove(vehicle);

                System.out.println("You've rented" + vehicle.toString() +  " for " + carRentingDays + " days"+ " that will cost you " + totalCost + "kr" );
                rentCar(vehicle,totalCost,carRentingDays);
            }
            else{
                System.out.println("Come on, you cant rent a car for 0 days, stop trolling");
                daysToRent();
            }
        }
        catch (Exception e){
            System.out.println("Please enter a number");
            daysToRent();
        }
    }
    
    private void rentCar(Vehicle vehicle, int totalCost, int carRentingDays){
        vehicle.driveCar(vehicle.getBrand());
        vehicle.returnCar(vehicle,totalCost,carRentingDays);
    }

    // Metod där kvittot skapas i en ny map om den inte redan existerar annars uppdateras kvittot bara
    public void printReceipt(Vehicle vehicle, int totalCost,int carRentingDays) {
        System.out.println("Here is your receipt, thank you for your Choosing Grit Academys Car Shop");
        try{
            File directory = new File("Files");
            if(!directory.exists()){
                directory.mkdir();
            }
            File file = new File(directory, "Receipt.txt");
            FileWriter writer = new FileWriter(file);
            BufferedWriter buffer = new BufferedWriter(writer);

            buffer.write("Grit Academy Car Shop Receipt:\n");
            buffer.write("Car information: " + vehicle.toString() +"\n");
            buffer.write(" Rented for: " + carRentingDays + " days\n");
            buffer.write(" Cost: " + totalCost + " kr");
            buffer.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}