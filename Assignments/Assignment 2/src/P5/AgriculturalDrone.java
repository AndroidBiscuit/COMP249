/**
 * Name and ID: Faizan Ahmad 40200581
 * COMP249
 * Assignment #2
 * Due Date October 23rd 2020
 */

package P5;

import P4.UAV;

public class AgriculturalDrone extends UAV {
    private String brand;
    private int carryCapacity;

    /**
     * Default constructor
     */
    public AgriculturalDrone(){
        //
    }

    /**
     * Parameterized constructor
     * @param weight double representing the weight of the agricultural drone
     * @param price double representing the price of the agricultural drone
     * @param brand String representing the brand of the agricultural drone
     * @param carryCapacity int representing the passenger capacity of the agricultural drone
     */
    public AgriculturalDrone(double weight, double price, String brand, int carryCapacity){
        super(weight, price);
        this.brand = brand;
        this.carryCapacity = carryCapacity;
    }

    /**
     * Copy constructor
     * @param agriculturalDrone object of type AgriculturalDrone
     */
    public AgriculturalDrone(AgriculturalDrone agriculturalDrone){
        this.setWeight(agriculturalDrone.getWeight());
        this.setPrice(agriculturalDrone.getPrice());
        this.brand = agriculturalDrone.brand;
        this.carryCapacity = agriculturalDrone.carryCapacity;
    }

    public String getBrand(){
        return this.brand;
    }

    public int getCarryCapacity(){
        return this.carryCapacity;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public void setCarryCapacity(int carryCapacity){
        this.carryCapacity = carryCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Brand: " + this.brand + "\n" + "Carry capacity: " + this.carryCapacity;
    }

    public boolean equals(AgriculturalDrone firstAgriculturalDrone, AgriculturalDrone secondAgriculturalDrone) {
        return (super.equals(firstAgriculturalDrone, secondAgriculturalDrone) &&
                (firstAgriculturalDrone.brand.equals(secondAgriculturalDrone.brand) &&
                        firstAgriculturalDrone.carryCapacity == secondAgriculturalDrone.carryCapacity));
    }
}
