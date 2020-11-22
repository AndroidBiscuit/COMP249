public class DelMonte implements JuiceFactory {

    class Apple implements AppleJuice{

        @Override
        public void getAppleJuiceInfo() {
            System.out.println("Created an apple juice");
        }
    }

    class Orange implements OrangeJuice{

        @Override
        public void getOrangeJuiceInfo() {
            System.out.println("Created an orange juice");
        }
    }

    @Override
    public AppleJuice createAppleJuice() {
        return new Apple();
    }

    @Override
    public OrangeJuice createOrangeJuice() {
        return new Orange();
    }
}
