package Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Garage   {
   private Map<String, List<Vehicle>> vehicleType = new HashMap<>();

   // Metod för att lägga till bilar i rätt kategori
    public void addVehicle(String type,Vehicle vehicle) {
        vehicleType.putIfAbsent(type, new ArrayList<>());
        vehicleType.get(type).add(vehicle);
    }

    public List<Vehicle> getVehicle(String type) {
        return vehicleType.getOrDefault(type, new ArrayList<>());
    }
}
