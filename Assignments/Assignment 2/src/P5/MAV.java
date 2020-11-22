/**
 * Name and ID: Faizan Ahmad 40200581
 * COMP249
 * Assignment #2
 * Due Date October 23rd 2020
 */

package P5;

import P4.UAV;

public class MAV extends UAV {
    private String model;
    private double size;

    /**
     * Default constructor
     */
    public MAV(){
        //
    }

    /**
     * Parameterized constructor
     * @param weight double representing the weight of the MAV
     * @param price double representing the price of the MAV
     * @param model String representing the model of the MAV
     * @param size double representing the size of the MAV
     */
    public MAV(double weight, double price, String model, double size){
        super(weight, price);
        this.model = model;
        this.size = size;
    }

    /**
     * Copy constructor
     * @param mav object of type MAV
     */
    public MAV(MAV mav){
        this.setWeight(mav.getWeight());
        this.setPrice(mav.getPrice());
        this.model = mav.model;
        this.size = mav.size;
    }

    public String getModel(){
        return this.model;
    }

    public double getSize(){
        return this.size;
    }

    public void setModel(String model){
        this.model = model;
    }

    public void setSize(double size){
        this.size = size;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Model: " + this.model + "\n" + "Size: " + this.size;
    }

    public boolean equals(MAV firstMAV, MAV secondMAV) {
        return (super.equals(firstMAV, secondMAV) &&
                (firstMAV.model.equals(secondMAV.model) &&
                        firstMAV.size == secondMAV.size));
    }
}
