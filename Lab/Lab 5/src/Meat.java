import javax.swing.text.html.StyleSheet;

public class Meat extends Food {
    String meatType;

    /**
     * Default constructor
     */
    public Meat(){
        super();
    }

    /**
     * Parametric constructor
     * @param calories int representing the number of calories per 100gr of the meat
     * @param weight double representing the weight of the meat
     * @param price double representing the price of the meat
     * @param meatType String representing the type of the meat
     */
    public Meat(int calories, double weight, double price, String meatType){
        super(calories, weight, price);
        this.meatType = meatType;
    }

    /**
     * Accessor for the type of the meat
     * @return String representing the type of the meat
     */
    public String getMeatType(){
        return this.meatType;
    }

    /**
     * Mutator for the type of the meat
     * @param meatType String representing the type of the meat
     */
    public void setMeatType(String meatType){
        this.meatType = meatType;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Meat type: " + this.meatType;
    }

    @Override
    double computeTotalCalories() {
        return weight*calories*4.54;
    }

    @Override
    void information() {
        System.out.println("This is a " + weight + " pound box of " + meatType + " meat." + "\n" +
                "The calories in this type of meat per 100 grams are " + calories + " so it has a total of " +
                computeTotalCalories() + " calories.");
    }
}
