import java.util.HashMap;
import java.util.Map;

/**
 * The Node superclass which contain besides the name of the Node a HashMap where the key is a Node and the value represents the cost between the Node and the key Node of the map.
 *  It has constructors, getters and setters for different atributes of the class. The getCostfromKey method will give us the cost value of a key given as parameter.
 */
public abstract class Node {
    protected String name;
    protected   Map<Node,Integer> cost = new HashMap<>();

    public Node(String name, Map<Node, Integer> cost) {
        this.name = name;
        this.cost = cost;
    }

    public Node(String name) {
        this.name = name;
    }

    public Node() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Node, Integer> getCost() {
        return cost;
    }
    public int getCostfromKey(Node key) {
         return cost.get(key);

    }

    public void setCost(Map<Node, Integer> cost) {
        this.cost = cost;
    }
    public void setCost(Node node,int value) {
        cost.put(node, value);
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }




}
