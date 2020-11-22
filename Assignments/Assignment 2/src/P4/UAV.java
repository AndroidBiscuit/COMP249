/**
 * Name and ID: Faizan Ahmad 40200581
 * COMP249
 * Assignment #2
 * Due Date October 23rd 2020
 */

package P4;

import P1.Airplane;

public class UAV {
    private double weight;
    private double price;

    /**
     * Default constructor
     */
    public UAV(){
        //
    }

    /**
     * Parameterized constructor
     * @param weight double representing the weight of the UAV
     * @param price double representing the price of the UAV
     */
    public UAV(double weight, double price){
        this.weight = weight;
        this.price = price;
    }

    /**
     * Copy constructor
     * @param uav object of type UAV
     */
    UAV(UAV uav){
        this.weight = uav.weight;
        this.price = uav.price;
    }

    public double getWeight(){
        return this.weight;
    }

    public double getPrice(){
        return this.price;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public void setPrice(double price){
        this.price = price;
    }

    /**
     * Get a string with the brand, price and horse power of the airplane
     * @return String that contains the brand, price and horsepower of the airplane
     */
    public String toString(){
        return "Weight: " + this.weight + "\n" + "Price: " + this.price;
    }

    public boolean equals(UAV firstUAV, UAV secondUAV){
        if (firstUAV.getClass().equals(secondUAV.getClass())){
            if (firstUAV == null || secondUAV == null){
                return false;
            }
            else {
                return (firstUAV.price == secondUAV.price &&
                        firstUAV.weight == secondUAV.weight);
            }
        }
        else {
            return false;
        }
    }
}
