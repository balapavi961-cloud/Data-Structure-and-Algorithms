import java.util.*;

class Connected {
    private int V; // number of vertices
    private List<List<Integer>> adj; // adjacency list

    // Constructor
    Connected(int V) {
        this.V = V;
        adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add edge (undirected graph)
    void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // DFS helper
    void dfs(int node, boolean[] visited, List<Integer> component) {
        visited[node] = true;
        component.add(node);

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, component);
            }
        }
    }

    // Find and print connected components
    void connectedComponents() {
        boolean[] visited = new boolean[V];
        int count = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, visited, component);
                count++;

                System.out.println("Component " + count + ": " + component);
            }
        }
    }
}

public class Example {
    public static void main(String[] args) {

        // Create graph with 7 vertices (0 to 6)
        Connected g = new Connected(7);

        // Add edges
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(5, 6);

        /*
           Graph structure:
           0 -- 1 -- 2     (Component 1)
           3 -- 4          (Component 2)
           5 -- 6          (Component 3)
        */

        // Find connected components
        g.connectedComponents();
    }
}
