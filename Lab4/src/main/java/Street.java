public class Street {
    private String name;
    private int length;


    public Street(String name, int length) {
        this.name = name;
        this.length = length;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }



    @java.lang.Override
    public java.lang.String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", length=" + length +
                '}';
    }
}