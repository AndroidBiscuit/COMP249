/**
 * Name and ID: Faizan Ahmad 40200581
 * COMP249
 * Assignment #1
 * Due Date October 2nd 2020
 */

public class Appliance {
    private String type;
    private String brand;
    private long serialNumber;
    private double price;
    private String[] applianceTypes = {"Fridge", "Air Conditioner", "Washer", "Dryer", "Freezer", "Stove",
            "Dishwasher", "Water Heater", "Microwave"};
    private static int objectCounter = 0;

    /**
     * Constructor of this class.
     * Uses some methods to make sure that the required parameters are of the correct type, size and format
     * @param type String representing the type of the appliance
     * @param brand String representing the brand of the appliance
     * @param serialNumber long representing the serial number of the appliance
     * @param price double representing the price of the appliance
     */
    public Appliance(String type, String brand, long serialNumber, double price){
        if (checkApplianceType(type)){
            this.type = type;
        }
        else{
            throw new IllegalArgumentException("Error - This is not an appliance type");
        }

        if (price >= 1){
            this.price = price;
        }
        else{
            throw new IllegalArgumentException("Error - The price cannot be lower than 1$");
        }

        if (checkSerialNumber(serialNumber)){
            this.serialNumber = serialNumber;
        }
        else{
            throw new IllegalArgumentException("Error - This is not an valid serial number format");
        }

        this.brand = brand;
        objectCounter++;
    }

    /**
     * Copy constructor
     * @param appliance object of type Appliance used to make the copy constructor
     */
    public Appliance(Appliance appliance){
        this.type = appliance.type;
        this.brand = appliance.brand;
        this.serialNumber = appliance.serialNumber;
        this.price = appliance.price;
    }

    /**
     * Accessor for the appliance type
     * @return String representing the type of the appliance
     */
    public String getType(){
        return this.type;
    }

    /**
     * Accessor for the appliance brand
     * @return String representing the brand of the appliance
     */
    public String getBrand(){
        return this.brand;
    }

    /**
     * Accessor for the appliance serial number
     * @return long representing the serial number of the appliance
     */
    public long getSerialNumber(){
        return this.serialNumber;
    }

    /**
     * Accessor for the appliance price
     * @return double representing the price of the appliance
     */
    public double getPrice(){
        return this.price;
    }

    /**
     * Mutator for the appliance type
     * Checks if the appliance type
     * @param type String representing the type of the appliance
     */
    public void setType (String type){

        checkApplianceType(type);
        for (int i = 0; i < this.applianceTypes.length; i++){
            if (type.equals(this.applianceTypes[i])){
                this.type = type;
            }
            else {
                throw new IllegalArgumentException("Error - This is not an appliance type");
            }
        }
    }

    /**
     * Mutator for the appliance brand
     * @param brand String representing the brand of the appliance
     */
    public void setBrand (String brand){
        this.brand = brand;
    }

    /**
     * Mutator for the appliance serial number
     * @param serialNumber long representing the serial number of the appliance
     */
    public void setSerialNumber (long serialNumber){
        this.serialNumber = serialNumber;
    }

    /**
     * Mutator for the appliance price
     * @param price double representing the price of the appliance
     */
    public void setPrice (double price){
        if (checkPrice(price)){
            this.price = price;
        }
        else {
            throw new IllegalArgumentException("Error - The price cannot be lower than 1$");
        }
    }

    /**
     * Check if the appliance type is among those listed in the instructions
     * (and also in applianceTypes up with the private variables)
     * @param type String representing the entered type of the appliance
     * @return Boolean representing if the entered type is acceptable
     */
    public Boolean checkApplianceType(String type){
        for (int i = 0; i < this.applianceTypes.length; i++){
            if (type.equals(this.applianceTypes[i])){
                return true;
            }
        }
        return false;
    }

    /**
     * Check if the appliance price is at least 1$
     * @param appliancePrice double representing the entered price of the appliance
     * @return Boolean representing if the entered price is acceptable
     */
    public Boolean checkPrice(double appliancePrice){
        return (price >= 1.0);
    }

    /**
     * Check if the appliance's serial number is of the correct format
     * @param enteredSerialNumber long representing the entered price of the appliance
     * @return Boolean representing if the entered serial number is acceptable
     */
    public Boolean checkSerialNumber(long enteredSerialNumber){
        if (enteredSerialNumber >= 1000000){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Print all the information of an object at once
     */
    public void ToString(){
        System.out.println( "Appliance Serial # " + this.serialNumber + "\n" +
                "Brand: " + this.brand + "\n" +
                "Type: " + this.type + "\n" +
                "Price: " + this.price);
    }

    /**
     * Checks if two appliances are the same.
     * Checks the brand, type and price.
     * @param firstAppliance Object of type Appliance (to be compared to another object of the same type)
     * @param secondAppliance Object of type Appliance (to be compared to another object of the same type)
     * @return Boolean representing if the both appliances are the same
     */
    public boolean applianceEquals(Appliance firstAppliance, Appliance secondAppliance){
        return ((firstAppliance.getBrand() == secondAppliance.getBrand()) &&
                (firstAppliance.getType() == secondAppliance.getType()) &&
                (firstAppliance.getPrice() == secondAppliance.getPrice()));
    }

    public int findNumberOfCreatedAppliances(){
        return objectCounter;
    }
}
