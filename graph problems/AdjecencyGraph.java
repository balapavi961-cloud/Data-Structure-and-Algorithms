import java.util.*;
class Graph{
    private int graph[][];
    private int vertices;

    Graph(int vertices){
        this.vertices = vertices;
        graph = new int[vertices][vertices];
    }
    public void addEdge(int i,int j){
        graph[i][j] = 1;
        graph[j][i] = 1;
    }
    public void removeEdge(int i,int j){
        graph[i][j]=0;
        graph[j][i]=0;
    }
    public void addVertex(){
        int[][] arr = new int[vertices+1][vertices+1];

        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                arr[i][j] = graph[i][j];
            }
        }
        graph = arr;
        vertices++;
    }
    public void removeVertex(int v){
        int[][] arr = new int[vertices-1][vertices-1];

        for(int i=0; i<vertices;i++){
            for(int j=0;j<vertices;j++){
                if(i != v && j!= v){
                    arr[i][j] = graph[i][j];
                }
            }
        }
        graph = arr;
        vertices--;
    }
    public void display(){
        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("The Connection between Nodes");
        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                if(graph[i][j] == 1){
                    System.out.println("Node "+i+" is Connected with the Node "+j);
                }
            }
        }
    }
}
public class AdjecencyGraph {
    public static void main(String[] args){
        Graph g = new Graph(4);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,3);
        g.display();
    }
}
