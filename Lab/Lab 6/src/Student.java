public class Student {
    private String name;
    private String id;
    private char grade;

    public Student(String name, String id, char grade){
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName(){
        return this.name;
    }

    public String getId(){
        return this.id;
    }

    public char getGrade(){
        return this.grade;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setGrade(char grade){
        this.grade = grade;
    }

    public String toString(){
        return this.name + "\n" + this.id + "\n" + this.grade;
    }
}
