public class Cylinder {
    private double radius;
    private double height;

    /**
     * Default Constructor
     * @param r double representing the radius of the cylinder
     * @param h double representing the height of the cylinder
     */
    public Cylinder(double r, double h){
        this.radius = r;
        this.height = h;
    }

    /**
     * Copy Constructor
     * @param c Cylinder object used by the copy constructor
     */
    public Cylinder(Cylinder c){
        this.radius = c.radius;
        this.height = c.height;
    }

    /**
     * Radius accessor
     * @return double value representing the radius of the cylinder
     */
    public double getRadius(){
        return this.radius;
    }

    /**
     * Height accessor
     * @return double value representing the height of the cylinder
     */
    public double getHeight(){
        return this.height;
    }

    /**
     * Radius mutator
     * @param r double value representing the radius of a cylinder
     */
    public void setRadius(double r){
        this.radius = r;
    }

    /**
     * Height mutator
     * @param h double value representing the height of a cylinder
     */
    public void setHeight(double h){
        this.height = h;
    }

    /**
     * Equals method to return true if the objects have the same radius and height
     * @param firstCylinder first cylinder object
     * @param secondCylinder second cylinder object
     * @return boolean representing if the two cylinders are the same
     */
    public boolean cylinderEquals(Cylinder firstCylinder, Cylinder secondCylinder){
        return (firstCylinder.getRadius() == secondCylinder.getRadius()) &&
                (firstCylinder.getHeight() == secondCylinder.getHeight());
    }

    /**
     * Calculate the area of the cylinder
     * @return
     */
    public double getArea(){
        return (2.0*this.radius*this.radius*Math.PI) + (2.0*this.radius*this.height*Math.PI);
    }

    // toString method
    public String toString(){
        return "Radius: " + this.radius + "\n" + "Height: " + this.height + "\n" + "Area: " + getArea() + "\n";
    }

    // getTotalArea method
    static double getTotalArea(Cylinder[] cylinderArray){
        double totalArea = 0;

        for (int i = 0; i < cylinderArray.length; i++){
            totalArea += cylinderArray[i].getArea();
        }

        return totalArea;
    }

    /**
     * According to the discussion between a student and the lab TA, the driver method is not necessary, so it is not
     * implemented in this .java file. There may be another file included with this one that could test this class,
     * if I have the time.
     */

}
