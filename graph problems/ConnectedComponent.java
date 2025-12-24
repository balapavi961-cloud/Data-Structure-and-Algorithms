import java.util.*;

public class ConnectedComponent {

    static void dfs(List<List<Integer>> adj, boolean[] visited, int node) {
        visited[node] = true;
        for (int neigh : adj.get(node)) {
            if (!visited[neigh]) {
                dfs(adj, visited, neigh);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adj, visited, i);
                components++;
            }
        }

        System.out.println("Connected Components: " + components);
    }
}
