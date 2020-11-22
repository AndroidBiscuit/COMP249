/**
 * Name and ID: Faizan Ahmad 40200581
 * COMP249
 * Assignment #2
 * Due Date October 23rd 2020
 */

package P2;

import P1.Airplane;

public class Helicopter extends Airplane {
    private int numberOfCylinders;
    private int creationYear;
    private int passengerCapacity;

    /**
     * Default constructor
     */
    public Helicopter(){
        super();
    }

    /**
     * Parameterized constructor
     * @param brand String representing the brand of the helicopter
     * @param price double representing the price of the helicopter
     * @param horsePower int representing the horse power of the helicopter
     * @param numberOfCylinders int representing the number of cylinders of the helicopter
     * @param creationYear int representing the creation year of the helicopter
     * @param passengerCapacity int representing the passenger capacity of the helicopter
     */
    public Helicopter(String brand, double price, int horsePower, int numberOfCylinders,
                      int creationYear, int passengerCapacity){
        super(brand, price, horsePower);
        this.numberOfCylinders = numberOfCylinders;
        this.creationYear = creationYear;
        this.passengerCapacity = passengerCapacity;
    }

    /**
     * Copy constructor
     * @param helicopter object of type Helicopter
     */
    public Helicopter(Helicopter helicopter){
        this.setBrand(helicopter.getBrand());
        this.setPrice(helicopter.getPrice());
        this.setHorsePower(helicopter.getHorsePower());
        this.numberOfCylinders = helicopter.numberOfCylinders;
        this.creationYear = helicopter.creationYear;
        this.passengerCapacity = helicopter.passengerCapacity;
    }

    /**
     * Accessor for the number of cylinders of the helicopter
     * @return int representing the number of cylinders of the helicopter
     */
    public int getNumberOfCylinders(){
        return this.numberOfCylinders;
    }

    /**
     * Accessor for the creation year of the helicopter
     * @return int representing the creation year of the helicopter
     */
    public int getCreationYear(){
        return this.creationYear;
    }

    /**
     * Accessor for the passenger capacity of the helicopter
     * @return int representing the passenger capacity of the helicopter
     */
    public int getPassengerCapacity(){
        return this.passengerCapacity;
    }

    /**
     * Mutator for the number of cylinders of the helicopter
     * @param numberOfCylinders int representing the number of cylinders of the helicopter
     */
    public void setNumberOfCylinders(int numberOfCylinders){
        this.numberOfCylinders = numberOfCylinders;
    }

    /**
     * Mutator for the creation year of the helicopter
     * @param creationYear int representing the creation year of the helicopter
     */
    public void setCreationYear(int creationYear){
        this.creationYear = creationYear;
    }

    /**
     * Mutator for the passenger capacity of the helicopter
     * @param passengerCapacity int representing the passenger capacity of the helicopter
     */
    public void setPassengerCapacity(int passengerCapacity){
        this.passengerCapacity = passengerCapacity;
    }

    /**
     * Get a string with the info of the helicopter
     * @return String that contains the info of the helicopter
     */
    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Number of cylinders: " + this.numberOfCylinders + "\n" +
                "Creation year: " + this.creationYear + "\n" +
                "Passenger capacity: " + this.passengerCapacity;
    }

    /**
     * Checks if two helicopters are the same
     * @param firstHelicopter object of type helicopter to be compared
     * @param secondHelicopter object of type helicopter to be compared
     * @return boolean representing if the two compared helicopters are the same
     */
    public boolean equals(Helicopter firstHelicopter, Helicopter secondHelicopter) {
        return (super.equals(firstHelicopter, secondHelicopter) &&
                (firstHelicopter.numberOfCylinders == secondHelicopter.numberOfCylinders &&
                 firstHelicopter.creationYear == secondHelicopter.creationYear &&
                 firstHelicopter.passengerCapacity == secondHelicopter.passengerCapacity));
    }
}
