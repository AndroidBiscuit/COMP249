public class House {
    private String address;
    private Animal animal;

    public House(String address, Animal animal){
        this.address = address;
        this.animal=animal;
    }

    public String toString(){
        return "House: Address: " + this.address + ", Contains: " + this.animal;
    }

    public String getAddress(){
        return this.address;
    }

    public Animal getAnimal(){
        return this.animal;
    }
}
