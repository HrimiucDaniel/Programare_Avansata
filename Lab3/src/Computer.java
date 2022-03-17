/**
 * The Computer class which is a subclass of the Node class but also implements the Identifiable and Storage interfaces containing an adress and a storage capacity as atributes
 *
 */

public class Computer extends Node implements Identifiable, Storage{
    private String address;
    private int storageCapacity;


    public Computer(String name) {
        super(name);
    }

    @Override
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }
    @Override
    public int getStorageCapacity(){
        return storageCapacity;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "address='" + address + '\'' +
                ", storageCapacity=" + storageCapacity +
                ", name= " + name + '\'' +

                '}';
    }
}
