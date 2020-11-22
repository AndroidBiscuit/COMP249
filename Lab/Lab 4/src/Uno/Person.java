package Uno;

public class Person {
    private int numberOfSiblings;
    private String medicareID;
    private int dailyCalorieIntake = 2000;

    public Person(int numberOfSiblings, String medicareID){
        this.numberOfSiblings = numberOfSiblings;
        this.medicareID = medicareID;
    }

    // Overload constructor
    public Person(int numberOfSiblings, String medicareID, int newCalorie){
        this.numberOfSiblings = numberOfSiblings;
        this.medicareID = medicareID;
        this.dailyCalorieIntake = newCalorie;
    }

    public int getNumberOfSiblings(){
        return numberOfSiblings;
    }

    public String getMedicareID(){
        return medicareID;
    }

    public int getCalorieIntake(){
        return dailyCalorieIntake;
    }

    public void setNumberOfSiblings(int numberOfSiblings){
        this.numberOfSiblings = numberOfSiblings;
    }

    public void setMedicareID(String medicareID){
        this.medicareID = medicareID;
    }

    public String toString(){
        return "Number of siblings: " + numberOfSiblings + "\n" +
               "Medicare ID: " + medicareID + "\n" +
               "Calorie intake: " + dailyCalorieIntake;
    }
}
