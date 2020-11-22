public class Truck extends Vehicle {
    private int truckCapacity;

    public Truck(int numberOfWheels, int truckCapacity) {
        super(numberOfWheels);
        this.truckCapacity = truckCapacity;
    }

    public void setTruckCapacity(int truckCapacity){
        this.truckCapacity = truckCapacity;
    }

    public int getTruckCapacity(){
        return this.truckCapacity;
    }

    /*@Override
    public String toString() {
        return "Number of wheels: " + super.getNumberOfWheels() + "\n" + "Truck Capacity: " + this.truckCapacity;
    }*/

    @Override
    public String toString() {
        return super.toString()+ "\n" + "Truck Capacity: " + this.truckCapacity;
    }
}
