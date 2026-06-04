
import java.util.ArrayList;

class UndirectedGraph{
    int vertices;
    ArrayList<ArrayList<Integer>> adjList;

    public UndirectedGraph(int v) {
        vertices = v;
        adjList = new ArrayList<>();

        //Initialize the adjacency list
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v){
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    void printGraph(){
        for(int i = 0; i < vertices; i++){
            System.out.print(i + " -> ");
            for(int node : adjList.get(i)){
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

}

class DirectedGraph{
    int vertices;
    ArrayList<ArrayList<Integer>> adjList;

    public DirectedGraph(int v) {
        vertices = v;
        adjList = new ArrayList<>();

        //Initialize the adjacency list
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v){
        adjList.get(u).add(v);
    }

    void printGraph(){
        for(int i = 0; i < vertices; i++){
            System.out.print(i + " -> ");
            for(int node : adjList.get(i)){
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}

class AdList{
    public static void main(String[] args) {
        UndirectedGraph ug = new UndirectedGraph(5);
        ug.addEdge(1, 2);
        ug.addEdge(1, 4);
        ug.addEdge(2, 3);
        ug.addEdge(2, 0);
        ug.addEdge(3, 4);
        ug.addEdge(3, 0);
        System.out.println("Undirected Graph:");
        ug.printGraph();

        DirectedGraph dg = new DirectedGraph(5);
        dg.addEdge(1, 2);
        dg.addEdge(1, 4);
        dg.addEdge(2, 0);
        dg.addEdge(3, 2);
        dg.addEdge(4, 3);
        dg.addEdge(0, 3);
        System.out.println("\nDirected Graph:");
        dg.printGraph();
    }
}