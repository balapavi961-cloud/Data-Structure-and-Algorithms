import java.util.*;

class Edge {
    int to;
    int weight;

    Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

class GraphP {
    int V;
    List<List<Edge>> adj;

    GraphP(int V) {
        this.V = V;
        adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add directed edge (u → v with weight w)
    void addEdge(int from, int to, int weight) {
        adj.get(from).add(new Edge(to, weight));
    }

    // Print graph
    void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for (Edge e : adj.get(i)) {
                System.out.print("(" + e.to + ", " + e.weight + ") ");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {

        GraphP g = new GraphP(5);

        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 1);
        g.addEdge(2, 1, 2);
        g.addEdge(1, 3, 1);
        g.addEdge(2, 3, 5);
        g.addEdge(3, 4, 3);

        g.printGraph();
    }
}
