import java.util.LinkedList;
import java.util.Queue;

public class MyGraph {
    private int V, E;
    LinkedList<Integer>[] adj;

    public MyGraph(int n) {
        this.V = n;
        this.adj = new LinkedList[n];

        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }
    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    public void DFS() {
        boolean[] visited = new boolean[V];

        for (int v = 0; v < V; v++) {
            if(!visited[v]) {
                visitNode(v, visited);
            }
        }
    }

    public void BFS(int start) {

        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()) {
            int u = q.poll();
            visited[u] = true;
            System.out.print(u + " ");

            for (int w = 0; w < adj[u].size(); w++) {
                if(!visited[adj[u].get(w)]) {
                    visited[adj[u].get(w)] = true;
                    q.add(adj[u].get(w));
                }
            }
        }
    }

    public void myBFS(int start) {
        boolean[] visited = new boolean[V];
        visited[start] = true;
        System.out.print(start + " ");
        for (int v = 0; v < V; v++) {
            for (int w = 0; w < adj[v].size(); w++) {
                if(!visited[adj[v].get(w)]) visit(adj[v].get(w), visited);
            }
        }
    }

    public void visit(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
    }
    public void visitNode(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int w = 0; w < adj[v].size(); w++) {
            if(!visited[adj[v].get(w)]) {
                visitNode(adj[v].get(w), visited);
            }
        }
    }
    public void printGraph() {
        for (int v = 0; v < V; v++) {
            System.out.print("AdjList[" + v + "]: ");

            for (int w = 0; w < adj[v].size(); w++) {
                System.out.print(adj[v].get(w) + " ");
            }
            System.out.println();
        }
    }
}