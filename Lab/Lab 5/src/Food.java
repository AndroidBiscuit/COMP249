public abstract class Food {
    int calories;
    double weight;
    double price;

    /**
     * Default constructor
     */
    public Food(){
        //
    }

    /**
     * Parametric constructor
     * @param calories int representing the number of calories per 100gr of the food
     * @param weight double representing the weight of the food
     * @param price double representing the price of the food
     */
    public Food(int calories, double weight, double price){
        this.calories = calories;
        this.weight = weight;
        this.price = price;
    }

    /**
     * Accessor for the calories of the food
     * @return int representing the number of calories per 100gr of the food
     */
    public int getCalories(){
        return this.calories;
    }

    /**
     * Accessor for the weight of the food
     * @return double representing the weight of the food
     */
    public double getWeight(){
        return this.weight;
    }

    /**
     * Accessor for the price of the food
     * @return double representing the price of the food
     */
    public double getPrice(){
        return this.price;
    }

    /**
     * Mutator for the calories of the food
     * @param calories int representing the number of calories per 100gr of the food
     */
    public void setCalories(int calories){
        this.calories = calories;
    }

    /**
     * Mutator for the weight of the food
     * @param weight double representing the weight of the food
     */
    public void setWeight(double weight){
        this.weight = weight;
    }

    /**
     * Mutator for the price of the food
     * @param price double representing the price of the food
     */
    public void setPrice(double price){
        this.price = price;
    }

    /**
     * Print the variables (information) of the food
     * @return String representing the information of the food (calories, weight and price)
     */
    public String toString(){
        return "Calories per pound: " + this.calories + "\n" +
                "Weight: " + this.weight + "\n" +
                "Price: " + this.price;
    }

    //TODO abstract method computeTotalCalories()
    abstract double computeTotalCalories();

    //TODO abstract method information()
    abstract void information();


}
