import java.util.*;

public class Dijikstra {
    static class Pair {
        int node;
        int distance;

        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
    public static void dijkstra(int V, List<List<Pair>> adj, int source) {

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> a.distance - b.distance
        );

        dist[source] = 0;
        pq.add(new Pair(source, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            int currDist = current.distance;

            // Ignore outdated distances
            if (currDist > dist[node]) continue;

            for (Pair neighbor : adj.get(node)) {
                int nextNode = neighbor.node;
                int weight = neighbor.distance;

                if (dist[node] + weight < dist[nextNode]) {
                    dist[nextNode] = dist[node] + weight;
                    pq.add(new Pair(nextNode, dist[nextNode]));
                }
            }
        }


        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + " : " + dist[i]);
        }
    }
    public static void main(String[] args) {

        int V = 6;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(adj, 0, 1, 4);
        addEdge(adj, 0, 2, 2);
        addEdge(adj, 1, 2, 1);
        addEdge(adj, 1, 3, 5);
        addEdge(adj, 2, 3, 8);
        addEdge(adj, 2, 4, 10);
        addEdge(adj, 3, 4, 2);
        addEdge(adj, 3, 5, 6);
        addEdge(adj, 4, 5, 3);

        int source = 0;

        dijkstra(V, adj, source);
    }
    static void addEdge(List<List<Pair>> adj, int u, int v, int weight) {
        adj.get(u).add(new Pair(v, weight));
        adj.get(v).add(new Pair(u, weight)); 
    }
}
