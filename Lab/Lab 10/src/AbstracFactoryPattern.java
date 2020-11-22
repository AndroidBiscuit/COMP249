import java.util.ArrayList;

public class AbstracFactoryPattern implements AppleJuice, OrangeJuice{
    public void makeJuices (JuiceFactory factory){
        ArrayList<DelMonte> juiceArray = new ArrayList<>();

        AppleJuice juice1 = factory.createAppleJuice();
        AppleJuice juice2 = factory.createAppleJuice();
        OrangeJuice juice3 = factory.createOrangeJuice();
        OrangeJuice juice4 = factory.createOrangeJuice();
        OrangeJuice juice5 = factory.createOrangeJuice();

        juiceArray.add((DelMonte) juice1);
        juiceArray.add((DelMonte) juice2);
        juiceArray.add((DelMonte) juice3);
        juiceArray.add((DelMonte) juice4);
        juiceArray.add((DelMonte) juice5);

        for (int i = 0; i < 5; i++){
            System.out.println(juiceArray.get(i));
        }
    }

    @Override
    public void getAppleJuiceInfo() {

    }

    @Override
    public void getOrangeJuiceInfo() {

    }
}
