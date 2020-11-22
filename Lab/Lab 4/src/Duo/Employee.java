package Duo;

import Uno.Person;

public class Employee extends Person {
    public Employee(int numberOfSiblings, String medicareID) {
        // TODO add 1000 calories
        super(numberOfSiblings, medicareID, 3000);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "I don't have to study, HA!";
    }
}
