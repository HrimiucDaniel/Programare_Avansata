public class Lab3 {
    public static void  main(String args[]) {
        Node v1 = new Computer("A");
        Node v2 = new Router("B");
        Node v3 = new Switch("A");
        Node v4 = new Switch("B");
        Node v5 = new Router("B");
        Node v6 = new Computer("A=B");

        Network n1 = new Network();

        n1.addNode(v1);
        n1.addNode(v2);
        n1.addNode(v3);
        n1.addNode(v4);
        n1.addNode(v5);
        n1.addNode(v6);

        System.out.println(n1);

    }
}
