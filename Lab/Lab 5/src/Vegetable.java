public class Vegetable extends Food {
    String vegetableName;
    boolean cooked;

    public Vegetable(){
        super();
    }

    public Vegetable(int calories, double weight, double price, String vegetableName, boolean cooked){
        super(calories, weight, price);
        this.vegetableName = vegetableName;
        this.cooked = cooked;
    }

    public String getVegetableName(){
        return this.vegetableName;
    }

    public boolean getCooked(){
        return this.cooked;
    }

    public void setVegetableName(String vegetableName){
        this.vegetableName = vegetableName;
    }

    public void setCooked(boolean cooked){
        this.cooked = cooked;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Vegetable name: " + this.vegetableName + "\n" + "Cooked: " + this.cooked;
    }

    @Override
    double computeTotalCalories() {
        if (cooked){
            return 20.0 + weight * calories * 4.54;
        }
        else{
            return weight * calories * 4.54;
        }
    }

    @Override
    void information() {
        if (cooked){
            System.out.println("This is a " + weight + " pound box of cooked " + vegetableName +
                    " and the calories per 100 grams are " + calories + " so it has a total of " +
                    computeTotalCalories() + " calories.");
        }
        else {
            System.out.println("This is a " + weight + " pound box of raw " + vegetableName +
                    " and the calories per 100 grams are " + calories + " so it has a total of " +
                    computeTotalCalories() + " calories.");
        }
    }
}
