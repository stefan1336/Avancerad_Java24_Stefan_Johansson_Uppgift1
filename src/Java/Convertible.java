package Java;

import java.util.Scanner;

public class Convertible extends Vehicle{
    private boolean roof;
    String carRoof;
    Scanner scanner = new Scanner(System.in);

    public Convertible(String brand, String registerNumber, int price, boolean roof) {
        super(brand, registerNumber, price);
        this.roof = roof;
    }

    // Metod för att kunna välja om man vill köra med tak eller inte
    public void decideRoof(){
        while(true){
            System.out.println("Do you want to remove roof? y/n");
            String userInput = scanner.nextLine();

            if(userInput.equalsIgnoreCase("y")){
                this.roof = false;
                System.out.println("Roof has been removed");
                break;
            }
            else if(userInput.equalsIgnoreCase("n")){
                System.out.println("I hope that there aint no rain coming");
                break;
            }
            else {
                System.out.println("Invalid input, please try again");
            }
        }
    }

    @Override
    public void showCarDetails() {
        if(roof){
            carRoof = " The roof is on";
        }
        else {
            carRoof = " The roof is removed";
        }
        System.out.println("You just picked up keys to a " + getBrand() + carRoof);
    }

    @Override
    public String getCarType() {
        return "Convertible";
    }
}
