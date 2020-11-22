package Duo;

import Uno.Person;

public class Student extends Person {
    private int studyHours;

    public Student(int numberOfSiblings, String medicareID, int studyHours) {
        // TODO add 500 more calories
        super(numberOfSiblings, medicareID, 1500);
        this.studyHours = studyHours;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Number of study hours: " + studyHours;
    }
}
