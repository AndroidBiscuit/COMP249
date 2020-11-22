/**
 * Faizan Ahmad (40100581)
 */

public class Driver {
    public static void main(String args[]){

        AbstracFactoryPattern abstracFactoryPattern = new AbstracFactoryPattern();

        JuiceFactory juiceFactory = new DelMonte();
        abstracFactoryPattern.makeJuices(juiceFactory);
    }
}
