/**
 * The Router class which is a subclass of the Node class
 * It also has the address atribute which makes it an Identifiable object which means that it implements the Identifiable interface
 */

public class Router extends Node implements Identifiable{
    private String address;
    public Router(String name) {
        super(name);
    }

    public Router(String name, String address) {
        super(name);
        this.address = address;
    }

    @Override
    public String getAddress(){
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Router{" +
                "name='" + name + '\'' +
                "address= " + address +
                '}';
    }
}
