import java.util.HashMap;
import java.util.Map;
public abstract class Node {
    private String name;
    private  Map<Node,Integer> cost = new HashMap<>();

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
