public class Main {

    public static void main(String[] args) {

        MyGraph2 g = new MyGraph2(5);

        g.addEdge(0, 1, 70);
        g.addEdge(0, 2, 50);
        g.addEdge(0, 3, 100);
        g.addEdge(1, 2, 50);
        g.addEdge(2, 3, 40);
        g.addEdge(3, 4, 60);

        g.dijkstra(0, "Edinburgh");
    }

}