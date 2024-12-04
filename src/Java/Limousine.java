package Java;

import java.util.ArrayList;
import java.util.List;

public class Limousine extends Vehicle {
    private int limousineSeats;
    private String limousineDriver;

    // Lista med lyx till limousinen
    private List<String> luxury=new ArrayList<>();

    public Limousine(String brand, String registerNumber, int price, int limousineSeats, String limousineDriver) {
        super(brand, registerNumber, price);
        this.limousineSeats = limousineSeats;
        this.limousineDriver = limousineDriver;
    }

    @Override
    public void showCarDetails(){
        System.out.println("Limousine: " + getBrand() + ", Seats: " + getLimousineSeats() + ", Driver: " + getLimousineDriver());
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
