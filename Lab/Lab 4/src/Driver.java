import Duo.Employee;
import Duo.Student;
import Uno.Person;

public class Driver {
    public static void main(String arg[]){
        Person[] personArray = new Person[3];
        personArray[0] = new Person(2, "ABC123");;
        personArray[1] = new Student(3, "ABC456", 4);
        personArray[2] = new Employee(4, "ABC789");

        for (int i = 0; i < personArray.length; i++){
            System.out.println("-------------------------------");
            System.out.println(personArray[i].toString());
        }
    }
}
