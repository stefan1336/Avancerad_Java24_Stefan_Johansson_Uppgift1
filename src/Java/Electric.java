package Java;

public class Electric extends Vehicle {
    private int chargingTime;

    public Electric(String brand, String registerNumber, int price, int chargingTime) {
        super(brand, registerNumber, price);
        this.chargingTime = chargingTime;
    }

    public int getChargingTime() {
        return chargingTime;
    }

    @Override
    public void showCarDetails() {
        System.out.println("Electric car " + getBrand() + "charging time " + getChargingTime());
    }

    @Override
    public String getCarType() {
        return "Electric";
    }
}
