/**
 * Name and ID: Faizan Ahmad 40200581
 * COMP249
 * Assignment #1
 * Due Date October 2nd 2020
 */

import java.util.Scanner;

public class Main {
    private final static String mainPassword = "c249";
    private static int attemptCounter = 0;
    private static int currentInventory = 0;

    /**
     * Prints the main menu
     * (fig. 1 in assignment instructions).
     */
    static void printMainMenu(){
        System.out.print(
                "What do you want to do?" + "\n" +
                "   1.   Enter new appliances (password required)" + "\n" +
                "   2.   Change information of an appliance (password required)" + "\n" +
                "   3.   Display all appliances by a specific brand" + "\n" +
                "   4.   Display all appliances under a certain price" + "\n" +
                "   5.   Quit" + "\n" +
                "Please enter your choice > "
        );
    }

    /**
     * Executes the method selected by the user based on his input
     * @param scanner Object of the Scanner class used to take the user's input. Can also be passed to other methods
     */
    static void menuChoice(Scanner scanner, Appliance[] inventory, int maxAppliances){
        switch (scanner.nextInt()){
            case 1:
                enterAppliance(scanner, inventory, maxAppliances);
                break;
            case 2:
                changeInfo(scanner, inventory, maxAppliances);
                break;
            case 3:
                displayBrandAppliances(scanner, inventory, maxAppliances);
                break;
            case 4:
                displayPriceAppliances(scanner, inventory, maxAppliances);
                break;
            case 5:
                quitProgram();
                break;
            /*default:
                System.out.println();
                printMainMenu();
                menuChoice(scanner, inventory, maxAppliances);*/
        }
    }

    /**
     * Displays the main menu and takes an input (choice).
     * Very convenient to have and can be easily used to "exit" menus and come back to the main menu
     * @param scanner Object of the Scanner class used to take the user's input. Can also be passed to other methods
     * @param inventory Object of the Appliance class that contains the current inventory
     * @param maxAppliances int representing the maximum number of appliances
     */
    static void backToMainMenu(Scanner scanner, Appliance[] inventory, int maxAppliances){
        System.out.println();
        printMainMenu();
        menuChoice(scanner, inventory, maxAppliances);
    }

    /**
     * Asks the user for the password.
     * If the password is correct, it will reset the counter of failed attempts.
     * If the password is incorrect, it will ask the user to enter it again. After the third failed attempt, it
     * will re-open the main menu. This will be repeated at every third attempt (attempts 3, 6 and 9) and at the
     * 12th attempt the program will display an error message and will exit.
     * @param scanner Object of the Scanner class used to take the user's input. Can also be passed to other methods
     * @param highSecurity Boolean representing if it should behave with additional password protection (part d. i. in
     *                     the instructions, for menu option 1) or not (part e. i. in the instructions, for menu
     *                     option 2). This variable exists only because it is required to do the action asked for
     *                     in the instructions ("notice the different behaviour in that case from the previous one
     *                     above").
     */
    static void askPassword(Scanner scanner, Appliance[] inventory, int maxAppliances, boolean highSecurity){
        printLines();
        System.out.print("Please enter your password: ");

        if (mainPassword.equals(scanner.next())){
            attemptCounter = 0;
            return;
        }
        else {
            attemptCounter++;
            System.out.println("Incorrect password (Attempt #" + attemptCounter + ").");

            if ((attemptCounter % 3 == 0.0)){
                printLines();
                printMainMenu();
                menuChoice(scanner, inventory, maxAppliances);
            }
            if ((attemptCounter == 12) && highSecurity){
                printLines();
                System.out.println("Program detected suspicious activities and will terminate immediately!");
                quitProgram();
            }

            // Use of recursive method
            askPassword(scanner, inventory, maxAppliances, highSecurity);
        }
    }

    /**
     * Asks the user for input and returns an object of the Appliance class
     * @param scanner Object of the Scanner class used to take the user's input. Can also be passed to other methods
     */
    static Appliance addAppliance(Scanner scanner){
        String type;
        String brand;
        long serialNumber;
        double price;

        System.out.print("Enter the type of the appliance: ");
        type = scanner.next();
        System.out.print("Enter the brand of the appliance: ");
        brand = scanner.next();
        System.out.print("Enter the serial number of the appliance: ");
        serialNumber = scanner.nextLong();
        System.out.print("Enter the price of the appliance: ");
        price = scanner.nextDouble();

        Appliance appliance = new Appliance(type, brand, serialNumber, price);
        return appliance;
    }

    /**
     * Option 1 in the main menu.
     * Enters an appliance in the inventory array.
     * But first it asks the user the number of appliances they wish to enter after checking if the password is correct
     * (using askPassword method).
     * @param scanner Object of the Scanner class used to take the user's input. Can also be passed to other methods
     */
    static void enterAppliance(Scanner scanner, Appliance[] inventory, int maxAppliances){
        int numberOfAppliances;

        // Ask password
        askPassword(scanner, inventory, maxAppliances, true);

        // Ask how many appliances to enter
        System.out.print("How many appliances do you want to enter? ");
        numberOfAppliances = scanner.nextInt();
        System.out.println("-----------------------------------");

        // Check if there is enough space in the inventory
        if (numberOfAppliances <= (maxAppliances + currentInventory)){
            for (int i = 0; i < numberOfAppliances; i++){
                inventory[currentInventory + i] = addAppliance(scanner);
                System.out.println("-----------------------------------");
            }

            currentInventory += numberOfAppliances;
            backToMainMenu(scanner, inventory, maxAppliances);
        }
        else {
            System.out.println("Not enough space in your inventory. You can currently add " +
                    (maxAppliances - currentInventory) + " appliance(s).");
            printLines();
            printMainMenu();
            menuChoice(scanner, inventory, maxAppliances);
        }
    }

    /**
     * Prints the information of a specific appliance
     * @param inventory Object of the Appliance class that contains the current inventory
     * @param appliancePosition int representing the position of an appliance in the inventory object array
     */
    static void printApplianceInfo(Appliance[] inventory, int appliancePosition){
        System.out.println( "Appliance Serial # " + inventory[appliancePosition].getSerialNumber() + "\n" +
                "Brand: " + inventory[appliancePosition].getBrand() + "\n" +
                "Type: " + inventory[appliancePosition].getType() + "\n" +
                "Price: " + inventory[appliancePosition].getPrice()
        );
    }

    /**
     * Option 2 in the main menu.
     * Changes the information of an appliance.
     * But first it asks the user the number of appliances they wish to enter after checking if the password is correct
     * (using askPassword method).
     * @param scanner Object of the Scanner class used to take the user's input. Can also be passed to other methods
     * @param inventory Object of the Appliance class that contains the current inventory
     * @param maxAppliances int representing the maximum number of appliances
     */
    static void changeInfo(Scanner scanner, Appliance[] inventory, int maxAppliances){
        boolean foundSerial = false;
        int appliancePosition = 0;
        long searchedSerialNumber;

        printLines();;
        System.out.println("Change appliance information");

        // Ask password
        askPassword(scanner, inventory, maxAppliances, false);

        // Ask for serial number
        System.out.print("Enter the serial number of the appliance: ");
        searchedSerialNumber = scanner.nextLong();

        // Search for serial number
        for (int i = 0; i < currentInventory; i++){
            if (inventory[i].getSerialNumber() == searchedSerialNumber){
                foundSerial = true;
                appliancePosition = i;
                break;
            }
        }

        if (foundSerial){
            System.out.println("Appliance info:");
            printApplianceInfo(inventory, appliancePosition);

            while (true){
                System.out.print(
                        "What information would you like to  change?" + "\n" +
                                "   1.   Brand" + "\n" +
                                "   2.   Type" + "\n" +
                                "   3.   Price" + "\n" +
                                "   4.   Quit" + "\n" +
                                "Please enter your choice > "
                );

                switch (scanner.nextInt()){
                    case 1:
                        System.out.print("Enter the new brand: ");
                        inventory[appliancePosition].setBrand(scanner.next());
                        System.out.println("Here is the updated information: ");
                        printApplianceInfo(inventory, appliancePosition);
                        printLines();
                        break;
                    case 2:
                        System.out.print("Enter the new type: ");
                        inventory[appliancePosition].setType(scanner.next());
                        System.out.println("Here is the updated information: ");
                        printApplianceInfo(inventory, appliancePosition);
                        printLines();
                        break;
                    case 3:
                        System.out.print("Enter the new price: ");
                        inventory[appliancePosition].setPrice(scanner.nextDouble());
                        System.out.println("Here is the updated information: ");
                        printApplianceInfo(inventory, appliancePosition);
                        printLines();
                        break;
                    case 4:
                        backToMainMenu(scanner, inventory, maxAppliances);
                }
            }
        }
        else {
            // Figure 2 in instructions
            System.out.println("There is no appliance with that serial number." + "\n" +
                    "Do you want to try again or quit?" + "\n" +
                    "   1.   Try again" + "\n" +
                    "   2.   Quit"+ "\n" +
                    "Please enter your choice > "
            );

            switch (scanner.nextInt()){
                case 1:
                    // Recursive method
                    changeInfo(scanner, inventory, maxAppliances);
                    break;
                default:
                    backToMainMenu(scanner, inventory, maxAppliances);
            }
        }


    }

    /**
     * Option 3 in the main menu.
     * Prints all the appliances of a specific brand
     * @param scanner Object of the Scanner class used to take the user's input. Can also be passed to other methods
     * @param inventory Object of the Appliance class that contains the current inventory
     * @param maxAppliances int representing the maximum number of appliances
     */
    static void displayBrandAppliances(Scanner scanner, Appliance[] inventory, int maxAppliances){
        String brandName;
        boolean noneFound = true;

        printLines();
        System.out.print("Please enter a brand name: ");
        brandName = scanner.next();
        System.out.println("-----------------------------------");

        for (int i = 0; i < currentInventory; i++){
            if (inventory[i].getBrand().equals(brandName)){
                printApplianceInfo(inventory, i);
                noneFound = false;
                System.out.println("-----------------------------------");
            }
        }

        if (noneFound){
            System.out.println("There are no appliances of this brand in your inventory.");
        }

        System.out.print(
                "What do you want to do? " + "\n" +
                        "   1.   Search for another brand" + "\n" +
                        "   2.   Quit" + "\n" +
                        "Please enter your choice > "
        );
        switch (scanner.nextInt()) {
            case 1:
                // Recursive method
                printLines();
                displayBrandAppliances(scanner, inventory, maxAppliances);
                break;
            case 2:
                backToMainMenu(scanner, inventory, maxAppliances);
        }
    }

    /**
     * Option 4 in the main menu.
     * Prints the appliances that are under a price
     * @param scanner Object of the Scanner class used to take the user's input. Can also be passed to other methods
     * @param inventory Object of the Appliance class that contains the current inventory
     * @param maxAppliances int representing the maximum number of appliances
     */
    static void displayPriceAppliances(Scanner scanner, Appliance[] inventory, int maxAppliances){
        double priceSearch;
        boolean noneFound = true;

        printLines();
        System.out.print("Please enter a price: ");
        priceSearch = scanner.nextDouble();
        System.out.println("-----------------------------------");

        for (int i = 0; i < currentInventory; i++){
            if (inventory[i].getPrice() < priceSearch){
                printApplianceInfo(inventory, i);
                noneFound = false;
                System.out.println("-----------------------------------");
            }
        }

        if (noneFound){
            System.out.println("There are no appliances under this price in your inventory.");
        }

        System.out.print(
                "What do you want to do? " + "\n" +
                        "   1.   Search by another price" + "\n" +
                        "   2.   Quit" + "\n" +
                        "Please enter your choice > "
        );
        switch (scanner.nextInt()) {
            case 1:
                // Recursive method
                printLines();
                displayPriceAppliances(scanner, inventory, maxAppliances);
                break;
            case 2:
                backToMainMenu(scanner, inventory, maxAppliances);
        }
    }

    /**
     * Quits the program
     */
    static void quitProgram(){
        printLines();
        printLines();

        System.out.println("The program has been terminated!" + "\n" + "Have a nice day!");

        System.exit(0);
    }

    /**
     * Prints a line full of "=" symbols.
     * Used mainly for aesthetics to separate different sections
     */
    static void printLines(){
        System.out.println("==========================================================================");
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int maxAppliances = 0;

        // Welcome message
        printLines();
        System.out.println("Welcome! This program will help you track of the appliances in your store.");
        printLines();

        // Prompt the owner for a maximum number of appliances
        System.out.print("Please enter your maximum inventory: ");
        maxAppliances = scanner.nextInt();

        printLines();

        // Create an empty array
        Appliance[] inventory = new Appliance[maxAppliances];

        // Main menu
        printMainMenu();

        // Decision structure
        menuChoice(scanner, inventory, maxAppliances);
    }
}
