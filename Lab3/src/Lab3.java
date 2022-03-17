/**
 * The main project on which we create the Network from the example
 * The model doesn't contain the ordering of the Nodes
 */
public class Lab3 {
    public static void  main(String args[]) {
        Node v1 = new Computer("A");
        Node v2 = new Router("A");
        Node v3 = new Switch("A");
        Node v4 = new Switch("B");
        Node v5 = new Router("B");
        Node v6 = new Computer("B");

        v1.setCost(v2,10);
        v1.setCost(v3,50);
        v2.setCost(v3,20);
        v2.setCost(v4,20);
        v2.setCost(v5,20);
        v3.setCost(v4,10);
        v4.setCost(v5,30);
        v4.setCost(v6,10);
        v5.setCost(v6,20);

        Network n1 = new Network();

        n1.addNode(v1);
        n1.addNode(v2);
        n1.addNode(v3);
        n1.addNode(v4);
        n1.addNode(v5);
        n1.addNode(v6);

        Algorithm dijkstra = new Algorithm(n1);
        // System.out.println(dijkstra.shortest_path(v6,v1));
        System.out.println(n1.getNode(3));
        //System.out.println(n1);

    }
}
