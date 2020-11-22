/**
 * Name and ID: Faizan Ahmad 40200581
 * COMP249
 * Assignment #2
 * Due Date October 23rd 2020
 */

package P1;

public class Airplane {
    private String brand;
    private double price;
    private int horsePower;

    /**
     * Default constructor
     */
    public Airplane(){
        //
    }

    /**
     * Parameterized constructor
     * @param brand String representing the brand of the airplane
     * @param price double representing the price of the airplane
     * @param horsePower int representing the horse power of the airplane
     */
    public Airplane(String brand, double price, int horsePower){
        this.brand = brand;
        this.price = price;
        this.horsePower = horsePower;
    }

    /**
     * Copy constructor
     * @param airplane object of type Airplane
     */
    public Airplane(Airplane airplane){
        this.brand = airplane.brand;
        this.price = airplane.price;
        this.horsePower = airplane.horsePower;
    }

    /**
     * Accessor for the brand of the airplane
     * @return String representing the brand of the airplane
     */
    public String getBrand(){
        return this.brand;
    }

    /**
     * Accessor for the price of the airplane
     * @return double representing the price of the airplane
     */
    public double getPrice(){
        return this.price;
    }

    /**
     * Accessor for the horse power of the airplane
     * @return int representing the horse power of the airplane
     */
    public int getHorsePower(){
        return this.horsePower;
    }

    /**
     * Mutator for the brand of the airplane
     * @param brand String representing the brand of the airplane
     */
    public void setBrand(String brand){
        this.brand = brand;
    }

    /**
     * Mutator for the price of the airplane
     * @param price double representing the price of the airplane
     */
    public void setPrice(double price){
        this.price = price;
    }

    /**
     * Mutator for the horse power of the airplane
     * @param horsePower int representing the horse power of the airplane
     */
    public void setHorsePower(int horsePower){
        this.horsePower = horsePower;
    }

    /**
     * Get a string with the brand, price and horse power of the airplane
     * @return String that contains the brand, price and horsepower of the airplane
     */
    public String toString(){
        return "Brand: " + this.brand + "\n" +
               "Price: " + this.price + "\n" +
               "Horse power: " + this.horsePower;
    }

    /**
     * Checks if two airplanes are the same
     * @param firstAirplane object of type Airplane to be compared
     * @param secondAirplane object of type Airplane to be compared
     * @return boolean representing if the two compared airplanes are the same
     */
    public boolean equals(Airplane firstAirplane, Airplane secondAirplane){
        if (firstAirplane.getClass().equals(secondAirplane.getClass())){
            if (firstAirplane == null || secondAirplane == null){
                return false;
            }
            else {
                return (firstAirplane.brand.equals(secondAirplane.brand) &&
                        firstAirplane.price == secondAirplane.price &&
                        firstAirplane.horsePower == secondAirplane.horsePower);
            }
        }
        else {
            return false;
        }
    }
}
