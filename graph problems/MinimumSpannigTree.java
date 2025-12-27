import java.util.*;

class MinimumSpanningTree {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];

        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        boolean[] visited = new boolean[n];
        int[] minEdge = new int[n];

        Arrays.fill(minEdge, Integer.MAX_VALUE);
        minEdge[0] = 0;

        int totalCost = 0;

        for (int i = 0; i < n; i++) {

            int u = -1;
            for (int v = 0; v < n; v++) {
                if (!visited[v] && (u == -1 || minEdge[v] < minEdge[u])) {
                    u = v;
                }
            }

            visited[u] = true;
            totalCost += minEdge[u];

            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !visited[v] && graph[u][v] < minEdge[v]) {
                    minEdge[v] = graph[u][v];
                }
            }
        }

        System.out.println("Minimum cost of MST: " + totalCost);
    }
}
