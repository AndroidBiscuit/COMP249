import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ClassHandler {
    private Student student;
    private String path;

    public ClassHandler(Student student, String path){
        this.student = student;
        this.path = path;
    }

    public Student getStudent(){
        return this.student;
    }

    public String getPath(){
        return this.path;
    }

    public void setStudent(Student student){
        this.student = student;
    }

    public void setPath(String path){
        this.path = path;
    }

    public void writeToFile(String fileName) throws FileNotFoundException {
        try{
            File file = new File(path);
            PrintWriter writer = new PrintWriter(fileName + ".txt");
            writer.println(student.toString());
            writer.close();
            path = path + "\\" + fileName + ".txt";

            System.out.println("Success");
        }
        catch (FileNotFoundException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public Student readFromFile() throws FileNotFoundException {
        try{
            File readFile = new File(path);
            Scanner reader = new Scanner(readFile);
            while(reader.hasNextLine()){
                student.setName(reader.nextLine());
                student.setId(reader.nextLine());
                student.setGrade(reader.nextLine().charAt(0));
            }
            reader.close();

            System.out.println("Success");
        }
        catch (FileNotFoundException e){
            System.out.println("Error");
            e.printStackTrace();
        }

        return student;
    }
}
