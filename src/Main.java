public class Main {





    public static void main(String[] args) {
        MyGraph g = new MyGraph(7);

        g.addEdge(0, 2); //A = 0
        g.addEdge(0, 1); //B = 1
        g.addEdge(0, 3); //C = 2
        g.addEdge(1, 2); //D = 3
        g.addEdge(1, 4); //E = 4
        g.addEdge(1, 6); //F = 5
        g.addEdge(2, 3); //G = 6
        g.addEdge(4, 6);
        g.addEdge(4, 5);

        g.printGraph();
        g.BFS(0);
    }
}