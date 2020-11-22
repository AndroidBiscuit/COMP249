

public class Driver {
    public static void main(String arg[]){
        Food[] foodArray = new Food[4];
        foodArray[0] = new Meat(50, 5.0, 10.0, "Lamb");;
        foodArray[1] = new Meat(75, 10.0, 15.0, "Cow");
        foodArray[2] = new Vegetable(25, 1.0, 5.0, "Broccoli", true);
        foodArray[3] = new Vegetable(20, 2.5, 7.5, "Lettuce", false);

        System.out.println("Iteration 1: information() method");
        for (int i = 0; i < foodArray.length; i++){
            System.out.println("-------------------------------");
            foodArray[i].information();
        }

        System.out.println();
        System.out.println();
        System.out.println("=====================================");
        System.out.println("=====================================");
        System.out.println();
        System.out.println();

        System.out.println("Iteration 2: total calories method");

        double totalVegetableCalories = 0;
        double totalMeatCalories = 0;

        for (int i = 0; i < 1; i++){
            totalMeatCalories += foodArray[i].computeTotalCalories();
        }

        for (int i = 2; i < 3; i++){
            totalVegetableCalories += foodArray[i].computeTotalCalories();
        }

        System.out.print("The total calories of all the vegetables are: " + totalVegetableCalories);
        System.out.print("The total calories of all the meats are: " + totalMeatCalories);
    }
}
