public class Driver {
    public static void main(String arg[]){
        Vehicle[] driverVehicles = new Vehicle[2];

        // The car has 4 wheels and a gasoline engine
        driverVehicles[0] = new Car(4, "Gasoline");

        // To make it a bit different from the car, my truck will have 6 wheels (straight truck) and a capacity of 100
        driverVehicles[1] = new Truck(6, 100);

        for (int i = 0; i < driverVehicles.length; i++){
            System.out.println(driverVehicles[i].toString());
        }
    }
}
