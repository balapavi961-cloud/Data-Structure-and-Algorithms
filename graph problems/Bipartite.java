import java.util.*;

public class Bipartite {
    static boolean dfs(List<List<Integer>> adj, int node, int[] color, int c) {
        color[node] = c;
        for (int neigh : adj.get(node)) {
            if (color[neigh] == 0) {
                if (!dfs(adj, neigh, color, -c)) {
                    return false;
                }
            } else if (color[neigh] == c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of nodes
        int m = sc.nextInt(); // number of edges

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] color = new int[n]; // 0 = not colored
        boolean isBipartite = true;

        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                if (!dfs(adj, i, color, 1)) {
                    isBipartite = false;
                    break;
                }
            }
        }

        if (isBipartite)
            System.out.println("Graph is Bipartite");
        else
            System.out.println("Graph is not Bipartite");
    }
}
