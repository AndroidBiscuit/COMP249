public class Vehicle {
    private int numberOfWheels;

    public Vehicle(int numberOfWheels){
        this.numberOfWheels = numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels){
        this.numberOfWheels = numberOfWheels;
    }
    public int getNumberOfWheels(){
        return this.numberOfWheels;
    }

    public String toString(){
        return "Number of wheels: " + this.numberOfWheels;
    }
}
