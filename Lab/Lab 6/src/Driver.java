import java.io.FileNotFoundException;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "E:\\Users\\Faizan\\Documents\\Polytechnique Montréal\\Concordia\\COMP 249 - Object-Oriented Programming II\\Lab\\Lab 6\\src";
        Student student = new Student("Faizan Ahmad", "40100581", 'A');

        // Show content of object
        System.out.println("The content of the student object are: ");
        System.out.println(student.toString());

        System.out.println("---------------------------------------");

        System.out.println("I changed the grade from A to B");
        student.setGrade('B');

        ClassHandler handler = new ClassHandler(student, path);

        handler.writeToFile("TestFile");

        handler.readFromFile();

        System.out.println(student.toString());

    }
}
