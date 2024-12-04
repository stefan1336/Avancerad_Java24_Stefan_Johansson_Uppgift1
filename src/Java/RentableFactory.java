package Java;

import Java.Interface.Rentable;

public class RentableFactory {
    public Rentable getRentableCar(String type) {
        switch (type) {
            case "Suv":
//                return new Suv();

            default:
                return null;
        }
    }
}
