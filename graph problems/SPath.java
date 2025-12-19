import java.util.*;

class GraphG {
    private int V;
    private List<List<Integer>> adj;

    // Constructor
    GraphG(int V) {
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

    // BFS shortest path from source
    void shortestPath(int src) {
        boolean[] visited = new boolean[V];
        int[] distance = new int[V];
        int[] parent = new int[V];

        Arrays.fill(distance, -1);
        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        visited[src] = true;
        distance[src] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[node] + 1;
                    parent[neighbor] = node;
                    queue.offer(neighbor);
                }
            }
        }

        // Print shortest distance and path
        for (int i = 0; i < V; i++) {
            System.out.print("Shortest path from " + src + " to " + i + ": ");

            if (distance[i] == -1) {
                System.out.println("No path");
            } else {
                printPath(i, parent);
                System.out.println(" (Distance = " + distance[i] + ")");
            }
        }
    }

    // Print path using parent array
    void printPath(int node, int[] parent) {
        List<Integer> path = new ArrayList<>();

        while (node != -1) {
            path.add(node);
            node = parent[node];
        }

        Collections.reverse(path);
        System.out.print(path);
    }
}

public class SPath {
    public static void main(String[] args) {

        // Create graph with 6 vertices (0 to 5)
        GraphG g = new GraphG(6);

        // Add edges
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);

        /*
            Graph:
            0 -- 1 -- 3 -- 4 -- 5
             \        /
              \-- 2 --
        */

        // Find shortest paths from source 0
        g.shortestPath(0);
    }
}
