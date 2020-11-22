/**
 * Name and ID: Faizan Ahmad 40200581
 * COMP249
 * Assignment #2
 * Due Date October 23rd 2020
 */

package P2;

public class Quadcopter extends Helicopter {
    private int maxFlyingSpeed;

    /**
     * Default constructor
     */
    public Quadcopter(){
        //
    }

    /**
     * Parameterized constructor
     * @param brand String representing the brand of the quadcopter
     * @param price double representing the price of the quadcopter
     * @param horsePower int representing the horse power of the quadcopter
     * @param numberOfCylinders int representing the number of cylinders of the quadcopter
     * @param creationYear int representing the creation year of the quadcopter
     * @param passengerCapacity int representing the passenger capacity of the quadcopter
     * @param maxFlyingSpeed int representing the maximum flying speed of the quadcopter
     */
    public Quadcopter(String brand, double price, int horsePower, int numberOfCylinders,
                      int creationYear, int passengerCapacity, int maxFlyingSpeed) {
        super(brand, price, horsePower, numberOfCylinders, creationYear, passengerCapacity);
        this.maxFlyingSpeed = maxFlyingSpeed;
    }

    /**
     * Copy constructor
     * @param quadcopter object of type Quadcopter
     */
    public Quadcopter(Quadcopter quadcopter){
        this.setBrand(quadcopter.getBrand());
        this.setPrice(quadcopter.getPrice());
        this.setHorsePower(quadcopter.getHorsePower());
        this.setNumberOfCylinders(quadcopter.getNumberOfCylinders());
        this.setCreationYear(quadcopter.getCreationYear());
        this.setPassengerCapacity(quadcopter.getPassengerCapacity());
        this.maxFlyingSpeed = quadcopter.maxFlyingSpeed;
    }

    public int getMaxFlyingSpeed(){
        return this.maxFlyingSpeed;
    }

    public void setMaxFlyingSpeed(int maxFlyingSpeed){
        this.maxFlyingSpeed = maxFlyingSpeed;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Max flying speed: " + this.maxFlyingSpeed;
    }

    // TODO
    //@Override
    public boolean equals(Quadcopter firstQuadcopter, Quadcopter secondQuadcopter) {
        return (super.equals(firstQuadcopter, secondQuadcopter) &&
                (firstQuadcopter.maxFlyingSpeed == secondQuadcopter.maxFlyingSpeed));
    }
}
