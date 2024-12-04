package Java;

import java.util.List;
import java.util.Scanner;

public class VehicleController {
    Scanner scanner = new Scanner(System.in);
    private Garage garage;
    private String carType = "";
    private User user;
    Vehicle vehicle;

    public VehicleController(){
        this.garage = new Garage();
        this.user = new User();
        fillGarage();
    }

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

    private void startShopping(){
        String userAnswer = scanner.nextLine();
        if(userAnswer.equalsIgnoreCase("y")){
            System.out.println("Show opinions");
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

    private void displayVehicleList(List<Vehicle>vehicleList){
        System.out.println("Thoose cars are available for this category: ");
        for(int i = 0; i < vehicleList.size(); i++){
            System.out.println((i+1)+". " + vehicleList.get(i).toString());
        }
        System.out.println("If you want any of thoose cars please enter the number of the car you want or type back if you want to see the other car types");
    }

    private void displayChosenCars(String userInput, List<Vehicle> vehicleList){
        try{
            int carNumber = Integer.parseInt(userInput) -1;
            if(carNumber >= 0 && carNumber < vehicleList.size()){
                vehicle = vehicleList.get(carNumber);
                vehicle.rentCar(vehicle.toString());
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

    private void daysToRent(){
        try{
            user.carCost(vehicle.toString());
            System.out.println("For how manny days do you want to rent the car?");
            int daysToRent = Integer.parseInt(scanner.nextLine());
            if(daysToRent > 0){
                int totalCost = vehicle.getPrice() * daysToRent;
                user.addCarRentalCost(totalCost);
                user.addCarToRent(vehicle);
                garage.getVehicle(carType).remove(vehicle);

                System.out.println("You've rented" + vehicle.toString() +  " for " + daysToRent + " days"+ " that will cost you " + totalCost + "kr" );
                rentCar(vehicle);
            }
            else{
                System.out.println("Come on, you cant rent a car for 0 days, stop trolling");
            }
        }
        catch (Exception e){
            System.out.println("not working error");
        }
    }
    
    public void rentCar(Vehicle vehicle){
        vehicle.driveCar(vehicle.getBrand());
//        driveCar(vehicle);
//        returnCar(vehicle);
    }

    private void returnCar(Vehicle vehicle) {
        System.out.println("Test return car");
    }
}

// Metod för kvitto som printas ut