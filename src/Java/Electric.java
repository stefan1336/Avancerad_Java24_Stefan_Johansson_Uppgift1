package Java;

import java.util.Scanner;

public class Electric extends Vehicle {
    private int chargingTime;
    Scanner scanner = new Scanner(System.in);

    public Electric(String brand, String registerNumber, int price, int chargingTime) {
        super(brand, registerNumber, price);
        this.chargingTime = chargingTime;
    }

    public int getChargingTime() {
        return chargingTime;
    }

    // Metod för att kunna ladda sin Elbil
    public void chargeCar(){
        System.out.println("You need to charge the battery for, how much do you want to charge your car");
        System.out.println("This car requires " + chargingTime + " h for full charge");
        while(true){
            try{
                System.out.println("For how many hours do you want to charge your car?");
                int chargingHours = Integer.parseInt(scanner.nextLine());
                if(chargingHours > 0 && chargingHours <= chargingTime){
                    System.out.println("The car will be charged for " + chargingHours + " hours");
                    break;
                }
                else{
                    System.out.println("Please enter a number");
                }
            }
            catch(NumberFormatException e){
                System.out.println("Please enter a number");
            }
        }
    }

    @Override
    public void showCarDetails() {
        System.out.println("You just picked up keys to a " + getBrand() + " I hope you charged the car,because it will only be driveable for  " + getChargingTime() + " h");
    }

    @Override
    public String getCarType() {
        return "Electric";
    }
}
