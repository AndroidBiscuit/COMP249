public class Car extends Vehicle {
    private String engineType;

    public Car(int numberOfWheels, String engineType) {
        super(numberOfWheels);
        this.engineType = engineType;
    }

    public void setEngineType(String engineType){
        this.engineType = engineType;
    }

    public String getEngineType(){
        return this.engineType;
    }

    @Override
    public String toString() {
        return super.toString()+ "\n" + "Engine type: " + this.engineType;
    }
}
