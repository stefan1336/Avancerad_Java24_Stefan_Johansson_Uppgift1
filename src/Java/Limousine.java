package Java;

import java.util.Scanner;

public class Limousine extends Vehicle {
    private int limousineSeats;
    private String limousineDriver;
    Scanner scan = new Scanner(System.in);

    public Limousine(String brand, String registerNumber, int price, int limousineSeats, String limousineDriver) {
        super(brand, registerNumber, price);
        this.limousineSeats = limousineSeats;
        this.limousineDriver = limousineDriver;
    }

    // Metod där olika föremål skapas och printas ut med nummer för att användaren ska kunna välja något till sin resa
    public void specialTreatment(){
        String[] luxuryItems = {"Champagne", "Chocolate", "Caviar", "Massage", "Live music from Zara Larsson"};
        System.out.println("What special luxury would you like? enter the number of the luxury item that you want");

        for (int i = 0; i < luxuryItems.length; i++) {
            System.out.println((i + 1) + ". " + luxuryItems[i]);
        }
        String userInput = scan.nextLine();
        choseLuxuryItem(userInput, luxuryItems);
    }

    // Metod där användaren får välja något till sin resa
    private void choseLuxuryItem(String userInput, String[] luxuryItems) {
        try{
            int userChoice = Integer.parseInt(userInput);
            if(userChoice >= 1 && userChoice <= luxuryItems.length){
                System.out.println("You have selected " + luxuryItems[userChoice-1] + " what a great choice!");
            }
            else{
                System.out.println("Please enter a number");
                specialTreatment();
            }
        }
        catch(NumberFormatException e){
            System.out.println("Please enter a number");
            specialTreatment();
        }
    }

    @Override
    public void showCarDetails(){
        System.out.println("You will be picked up by  " + getLimousineDriver() + " in a " + getLimousineSeats() + " seated Limo enjoy the ride");
    }

    public int getLimousineSeats() {
        return limousineSeats;
    }

    public String getLimousineDriver() {
        return limousineDriver;
    }

    @Override
    public String getCarType() {
        return  "Limousine";
    }
}
