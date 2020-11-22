public class driver {
    public static void main (String[] arg){
        Animal a = new Animal(2, "Emma", "Red");
        House h1 = new House("Montreal", a);
        a.setAge(3);
        a.setName("Liam");
        a.setColor("White");
        House h2 = new House("Toronto", a);
        System.out.println(h1+"\n"+h2);
    }
}
