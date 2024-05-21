import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MyGraph2 {
    private int V, E;
    private LinkedList<Edge>[] adj;
    public MyGraph2(int n) {
        this.V = n;
        this.adj = new LinkedList[n];

        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }
    public void addEdge(int v, int u, int weight) {
        adj[u].add(new Edge(v, weight));
        adj[v].add(new Edge(u, weight));
    }



    static class Edge {
        int to;
        int weight;

        Edge(int v, int w) {
            this.to = v;
            this.weight = w;
        }
    }
    static class Node {
        int vertex;
        int distance;

        Node(int v, int d) {
            this.vertex = v;
            this.distance = d;
        }
    }
    public void dijkstra(int start, String startName) {
        int[] distance = new int[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));

        while (!q.isEmpty()) {
            Node current = q.poll();
            visited[current.vertex] = true;

            for (Edge neighbor : adj[current.vertex]) {
                if (!visited[neighbor.to] && distance[current.vertex] + neighbor.weight < distance[neighbor.to]) {
                    distance[neighbor.to] = distance[current.vertex] + neighbor.weight;
                    q.add(new Node(neighbor.to, distance[neighbor.to]));
                }
            }
        }

        for (int i = 0; i < V; i++) {
            System.out.println("Distance from " + startName + " to " + i + " is " + distance[i]);
        }
    }




}