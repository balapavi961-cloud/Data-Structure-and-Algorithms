import java.util.*;

public class GraphGraph {
    public static boolean hasCycle(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj)) {
                    return true;
                }
            }
        }

        return false;
    }
    private static boolean dfs(int node, int parent,
                               boolean[] visited,
                               List<List<Integer>> adj) {

        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adj)) {
                    return true;
                }
            }
            else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {

        int n = 5;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 1},
                {3, 4}
        };

        boolean result = hasCycle(n, edges);

        if (result) {
            System.out.println("Cycle detected in the graph");
        } else {
            System.out.println("No cycle in the graph");
        }
    }
}
