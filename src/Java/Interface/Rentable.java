package Java.Interface;

public interface Rentable {
    public void rentCar(String car);
    public void returnCar(String car);
    public void payCar(String car);
}

// Definiera ett interface Rentable med metoder för att hyra ut och returnera
// fordon, samt beräkna hyreskostnaden.