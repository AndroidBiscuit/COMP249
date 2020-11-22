/**
 * Name and ID: Faizan Ahmad 40200581
 * COMP249
 * Assignment #2
 * Due Date October 23rd 2020
 */

package P3;

import P2.Helicopter;
import P2.Quadcopter;

public class Multirotor extends Helicopter {
    private int numberOfRotors;

    /**
     * Default constructor
     */
    public Multirotor(){
        //
    }

    /**
     * Parameterized constructor
     * @param brand String representing the brand of the multirotor
     * @param price double representing the price of the multirotor
     * @param horsePower int representing the horse power of the multirotor
     * @param numberOfCylinders int representing the number of cylinders of the multirotor
     * @param creationYear int representing the creation year of the multirotor
     * @param passengerCapacity int representing the passenger capacity of the multirotor
     * @param numberOfRotors int representing the number of rotors of the multirotor
     */
    public Multirotor(String brand, double price, int horsePower, int numberOfCylinders,
                      int creationYear, int passengerCapacity, int numberOfRotors) {
        super(brand, price, horsePower, numberOfCylinders, creationYear, passengerCapacity);
        this.numberOfRotors = numberOfRotors;
    }

    /**
     * Copy constructor
     * @param multirotor object of type Multirotor
     */
    public Multirotor(Multirotor multirotor){
        this.setBrand(multirotor.getBrand());
        this.setPrice(multirotor.getPrice());
        this.setHorsePower(multirotor.getHorsePower());
        this.setNumberOfCylinders(multirotor.getNumberOfCylinders());
        this.setCreationYear(multirotor.getCreationYear());
        this.setPassengerCapacity(multirotor.getPassengerCapacity());
        this.numberOfRotors = multirotor.numberOfRotors;
    }

    public int getNumberOfRotors(){
        return this.numberOfRotors;
    }

    public void setNumberOfRotors(int numberOfRotors){
        this.numberOfRotors = numberOfRotors;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Number of rotors: " + this.numberOfRotors;
    }

    // TODO
    //@Override
    public boolean equals(Multirotor firstMultirotor, Multirotor secondMultirotor) {
        return (super.equals(firstMultirotor, secondMultirotor) &&
                (firstMultirotor.numberOfRotors == secondMultirotor.numberOfRotors));
    }
}
