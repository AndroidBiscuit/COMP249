/**
 * Name and ID: Faizan Ahmad 40200581
 * COMP249
 * Assignment #2
 * Due Date October 23rd 2020
 *
 * IMPORTANT: I work alone, so everything in this assignment is written by me.
 * Since the assignment instructions do not specify what to name the packages,
 * I named them P1, P2, P3, etc.
 */

import P1.Airplane;
import P2.Helicopter;
import P2.Quadcopter;
import P3.Multirotor;
import P4.UAV;
import P5.AgriculturalDrone;
import P5.MAV;

import java.util.Arrays;

public class Driver {
    /**
     * Prints lines made of "-"
     * Used to "ease" the reading of the output
     */
    public static void printLine(){
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    // -----------------------------------------------------
    // Phase II
    // -----------------------------------------------------

    /**
     * Make a copy of an Airplane array
     * Used in Phase II of the assignment instructions
     * @param airplanes object of type Airplane
     * @return object of type Airplane (copy of the input)
     */
    public static Airplane[] copyFlyingObjects(Airplane[] airplanes){
        Airplane[] airplanesCopy = new Airplane[airplanes.length];
        for (int i = 0; i < airplanes.length; i++){
            airplanesCopy[i] = airplanes[i];
        }

        return airplanesCopy;
    }

    /**
     * Make a copy of an UAV array
     * Used in Phase II of the assignment instructions
     * Overload of the "copyFlyingObjects(Airplane[] airplanes)" method
     * @param uavs object of type UAV
     * @return object of type UAV (copy of the input)
     */
    public static UAV[] copyFlyingObjects(UAV[] uavs){
        UAV[]  uavsCopy = new UAV[uavs.length];
        for (int i = 0; i < uavs.length; i++){
            uavsCopy[i] = uavs[i];
        }

        return uavsCopy;
    }

    public static void main(String[] args){
        // -----------------------------------------------------
        // Phase I
        // -----------------------------------------------------

        // Make the required objects of the 7 classes
        System.out.println("Part 1: Create various objects from the 7 classes and display their information");

        Airplane airplane = new Airplane("Airbus", 1000000.0, 1500);

        Helicopter helicopter = new Helicopter("Bell", 500000.0,
                1000, 2, 2010, 6);

        Quadcopter quadcopter = new Quadcopter("DJI", 200.0, 5, 0,
                2011, 0, 15);

        Multirotor multirotor = new Multirotor("Skydio", 100.0, 5, 0,
                2015, 0, 6);

        UAV uav = new UAV(885, 4000000.0);

        AgriculturalDrone agriculturalDrone = new AgriculturalDrone(24.5, 1000.0, "DJI",
                16);

        MAV mav = new MAV(8.39, 10000.0, "RQ-16 T-Hawk", 0.25);

        // Print the created objects
        System.out.println(airplane.toString());
        printLine();
        System.out.println(helicopter.toString());
        printLine();
        System.out.println(quadcopter.toString());
        printLine();
        System.out.println(multirotor.toString());
        printLine();
        System.out.println(uav.toString());
        printLine();
        System.out.println(agriculturalDrone.toString());
        printLine();
        System.out.println(mav.toString());
        printLine();

        // ----------------------------------------------------------------------------------------------

        // Test equals method performance in each class
        System.out.println();
        printLine();
        printLine();
        System.out.println();
        System.out.println("Part 2: Test the equality of some of the created objects");

        System.out.print("Check if airplane and helicopter are the same: ");
        System.out.println(helicopter.equals(airplane, helicopter));

        Airplane secondAirplane = new Airplane("Airbus", 1000000.0, 1500);
        System.out.print("Check if two airplanes are the same: ");
        System.out.println(airplane.equals(airplane, secondAirplane));

        Helicopter secondHelicopter = new Helicopter();
        System.out.print("Check if two helicopters are the same: ");
        System.out.println(helicopter.equals(helicopter, secondHelicopter));

        System.out.print("Check if a MAV is itself: ");
        System.out.println(mav.equals(mav, mav));

        MAV secondMAV = new MAV(8.39, 0000.0, "ABC", 0.25);
        System.out.print("Check if two MAVs are the same: ");
        System.out.println(mav.equals(mav, secondMAV));

        // ----------------------------------------------------------------------------------------------

        // Make array of 15 flying objects
        System.out.println();
        printLine();
        printLine();
        System.out.println();
        System.out.println("Part 3: Create an array of 15 to 20 these flying objects and fill it");

        // Since UAV is not a child class of Airplane, I had to make two arrays of each type,
        // with a total of 15 flying objects (8 airplanes, 7 uavs)

        Quadcopter secondQuadcopter = new Quadcopter("DJI", 200.0, 5, 0,
                2011, 0, 15);

        Multirotor secondMultirotor = new Multirotor("Parrot", 175.0, 5, 0,
                2015, 0, 6);


        Airplane[] airplaneArray = new Airplane[8];
        airplaneArray[0] = airplane;
        airplaneArray[1] = secondAirplane;
        airplaneArray[2] = helicopter;
        airplaneArray[3] = secondHelicopter;
        airplaneArray[4] = quadcopter;
        airplaneArray[5] = secondQuadcopter;
        airplaneArray[6] = multirotor;
        airplaneArray[7] = secondMultirotor;

        UAV secondUAV = new UAV(90, 10000.0);

        AgriculturalDrone SecondAgriculturalDrone = new AgriculturalDrone(54.5, 5000.0, "Parrot",
                56);

        MAV newMAV = new MAV(4.0, 1000.0, "001 T-Hawk", 0.55);

        UAV[] uavArray = new UAV[7];
        uavArray[0] = uav;
        uavArray[1] = secondUAV;
        uavArray[2] = agriculturalDrone;
        uavArray[3] = SecondAgriculturalDrone;
        uavArray[4] = mav;
        uavArray[5] = secondMAV;
        uavArray[6] = newMAV;

        // Confirm the creation of the objects
        System.out.println("Done - object arrays created!");

        // ----------------------------------------------------------------------------------------------

        // Find cheapest object for each array
        System.out.println();
        printLine();
        printLine();
        System.out.println();
        System.out.println("Part 4: Trace that array to find the two objects that have the least expensive price");

        // Find cheapest object for airplane array
        int smallestPrice = 0;
        int secondSmallestPrice = 0;
        for (int i = 1; i < airplaneArray.length; i++){
            if (airplaneArray[i-1].getPrice() <= airplaneArray[i].getPrice()){
                smallestPrice = i-1;
                secondSmallestPrice = i;
            }
            else {
                smallestPrice = i;
                secondSmallestPrice = i-1;
            }
        }

        // Display object info and index
        System.out.println("The flying object of type airplane with the least expensive price is: ");
        System.out.println(airplaneArray[smallestPrice].toString());
        System.out.println("Array index: " + smallestPrice);

        printLine();
        System.out.println("The flying object of type airplane with the second least expensive price is: ");
        System.out.println(airplaneArray[secondSmallestPrice].toString());
        System.out.println("Array index: " + secondSmallestPrice);

        printLine();

        // Find cheapest object for uav array
        for (int i = 1; i < uavArray.length; i++){
            if (uavArray[i-1].getPrice() <= uavArray[i].getPrice()){
                smallestPrice = i-1;
                secondSmallestPrice = i;
            }
            else {
                smallestPrice = i;
                secondSmallestPrice = i-1;
            }
        }

        // Display object info and index
        System.out.println("The flying object of type UAV with the least expensive price is: ");
        System.out.println(uavArray[smallestPrice].toString());
        System.out.println("Array index: " + smallestPrice);

        printLine();
        System.out.println("The flying object of type UAV with the second least expensive price is: ");
        System.out.println(uavArray[secondSmallestPrice].toString());
        System.out.println("Array index: " + secondSmallestPrice);

        // ----------------------------------------------------------------------------------------------

        // -----------------------------------------------------
        // Phase II
        // -----------------------------------------------------

        System.out.println();
        printLine();
        printLine();
        System.out.println();
        System.out.println("Phase II: copyFlyingObjects method");

        // Use copyFlyingObjects to create copied arrays
        Airplane[] newAirplaneArray = copyFlyingObjects(airplaneArray);
        UAV[] newUavArray = copyFlyingObjects(uavArray);

        // Check if arrays are copies
        System.out.println("Are the Airplane arrays the same? " + Arrays.equals(newAirplaneArray, airplaneArray));
        System.out.println("Are the UAV arrays the same? " + Arrays.equals(newUavArray, uavArray));

    }
}
