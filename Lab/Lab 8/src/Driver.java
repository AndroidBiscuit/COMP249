import java.io.*;

public class Driver {
    public static void main(String[] args){
        System.out.println("Part 1: Make 10 employees");

        Employee employee[] = new Employee[10];
        employee[0] = new Employee("Faizan", 22, 100000.0);
        employee[1] = new Employee("Michel", 23, 90000.0);
        employee[2] = new Employee("Ayeshah", 24, 80000.0);
        employee[3] = new Employee("Dingwei", 21, 70000.0);
        employee[4] = new Employee("Jamall", 20, 60000.0);
        employee[5] = new Employee("Tawsif", 19, 50000.0);
        employee[6] = new Employee("Michael", 18, 40000.0);
        employee[7] = new Employee("Nicolas", 25, 30000.0);
        employee[8] = new Employee("Adrienne", 26, 20000.0);
        employee[9] = new Employee("Chris", 27, 10000.0);

        System.out.println("Done");
        System.out.println("----------------------------------------------");

        System.out.println("Part 2: Write them to a binary file");

        for (int i = 0; i < employee.length; i++){
            try{
                FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Faizan\\Desktop\\New folder\\data" + (i+1) + ".bin");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(employee[i]);
                out.close();
                fileOut.close();
                System.out.println("Serialized employee info saved in data" + (i+1) + ".bin");
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        System.out.println("Done");
        System.out.println("----------------------------------------------");

        System.out.println("Part 3: Change info for 3 employees");

        employee[3].setAge(29);
        employee[9].setName("Jim");
        employee[7].setSalary(85000.0);

        System.out.println("Done");
        System.out.println("----------------------------------------------");

        System.out.println("Part 4: Load from bin files and print info");

        Employee readEmployee[] = new Employee[10];

        for (int i = 0; i < readEmployee.length; i++) {
            try {
                FileInputStream fileIn = new FileInputStream("C:\\Users\\Faizan\\Desktop\\New folder\\data" + (i+1) + ".bin");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                readEmployee[i] = (Employee) in.readObject();
                in.close();
                fileIn.close();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            } catch (ClassNotFoundException c) {
                System.out.println("Employee class not found");
                c.printStackTrace();
                return;
            }

            System.out.println("----------------------------------------------");
            System.out.println("Employee # " + (i+1));
            System.out.println("Name: " + readEmployee[i].getName());
            System.out.println("Age: " + readEmployee[i].getAge());
            System.out.println("Salary: " + readEmployee[i].getSalary());
        }

        System.out.println("Done");
        System.out.println("End of program");
    }


}
