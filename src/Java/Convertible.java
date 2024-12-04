package Java;

public class Convertible extends Vehicle{
    private boolean roof;

    public Convertible(String brand, String registerNumber, int price, boolean roof) {
        super(brand, registerNumber, price);
        this.roof = true;
    }

    public void setRoof(boolean roof) {
        this.roof = roof;
    }

    // Metod för att sätta på taket
    private boolean activateRoof(){
        if(!roof == true){
            roof = true;
        }
        else{
            roof = false;
        }
        return roof;
    }

    // Metod för att ta av taket
    private boolean deactivateRoof(){
        if(roof == true){
            roof = false;
        }
        else{
            roof = true;
        }
        return roof;
    }

    @Override
    public void showCarDetails() {
        System.out.println("Convertible: " + getBrand() + "Possibility to take of roof ");
    }


    @Override
    public String getCarType() {
        return "Convertible";
    }
}
