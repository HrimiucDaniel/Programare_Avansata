import java.util.ArrayList;
import java.util.List;

/**
 * The Network class which contains a list of Nodes and can display them along with the adjacent Nodes and the costs from the cost map of the Node.
 *
 */
public class Network {
    private List<Node> nodes = new ArrayList<>();

    public Network(List<Node> nodes) {
        this.nodes = nodes;
    }

    public Network() {
    }

    public List<Node> getNodes() {
        return nodes;
    }
    public Node getNode(int i) {return nodes.get(i);}

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = i + 1; j < nodes.size(); j++) {
                if (nodes.get(i).getCost().containsKey(nodes.get(j))) {
                    sb.append("v");
                    sb.append(i + 1);
                    sb.append("--");
                    sb.append("v");
                    sb.append(j + 1);
                    sb.append(" :");
                    sb.append(nodes.get(i).getCost().get(nodes.get(j)));
                    sb.append("\n");
                }
            }

        }
        String ss = sb.toString();
        return ss;
    }
}
