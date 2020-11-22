public class Stack {
    private final int MAXCAPACITY = 10;
    private int[] pile;
    int position;

    public Stack(){
        this.position = 0;
    }

    public void push(int elm){

    }

    public int head(){
        return pile[position];
    }

    public int pop(){
        // TODO
        return position;
    }

    public void popAll(){
        // TODO
        for (int i = 0; i < pile.length; i++){
            System.out.println(pile[i]);
        }
    }
}
