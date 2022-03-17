import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * The Algorithm class implements the shortest_path methods which gives us the shortest cost path between two given nodes of a given network.
 * The algorithm used to solve the problem is based on the Dijkstra algorithm for finding out the shortest path between one node of the network and all the others
 * The costuri[] array will contain the shortest path between the source node and all the others. After the costuri[] array is updated we will go through the vector and search the cost of the destination code
 */
public class Algorithm {

    Network nodes = new Network();

    public Algorithm(Network nodes) {
        this.nodes = nodes;
    }

    public int  shortest_path(Node node_source, Node node_destination) {
        if (node_source == node_destination) return 0;
        Queue<Node> coada = new LinkedList<>();
        int distance = 0;
        int costuri[] = new int[nodes.getNodes().size()];

        for (int i = 0; i < costuri.length; i++) {
            costuri[i] = Integer.MAX_VALUE;
            if (nodes.getNode(i) == node_source) costuri[i] = 0;
        }
        coada.add(node_source);

        while(coada.size() != 0) {
            Node temporar = coada.peek();
            distance += costuri[nodes.getNodes().indexOf(temporar)];

            for (int j = 0; j < nodes.getNodes().size(); j++) {
                if (temporar.getCost().containsKey(nodes.getNode(j))) {
                    if (temporar.getCostfromKey(nodes.getNode(j)) + distance < costuri[j]) {
                        costuri[j] = temporar.getCostfromKey(nodes.getNode(j)) + distance;
                        coada.add(nodes.getNode(j));
                    }
                } else if (nodes.getNode(j).getCost().containsKey(temporar)) {
                    if (nodes.getNode(j).getCostfromKey(temporar) + distance < costuri[j]) {
                        costuri[j] = nodes.getNode(j).getCostfromKey(temporar) + distance;
                        coada.add(nodes.getNode(j));
                    }

                }

            }
            distance = 0;
            coada.remove();
        }
        for (int i = 0; i < nodes.getNodes().size(); i++) {
            if (node_destination == nodes.getNode(i)) return costuri[i];
        }
        return 0;
    }
}
