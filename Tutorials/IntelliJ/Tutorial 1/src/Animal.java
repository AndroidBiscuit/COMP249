public class Animal{
    private int age;
    private String name, color;

    public Animal (int age, String name, String color){
        this.age=age;
        this.color=color;
        this.name=name;
    }

    public String toString(){
        return "Animal: Name: " + this.name + ", Age: " + this.age + ", Color: " + this.color;
    }

    public void setAge(int age){
        this.age=age;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setColor(String color){
        this.color=color;
    }
}