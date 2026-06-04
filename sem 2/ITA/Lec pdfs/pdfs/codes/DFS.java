import java.util.ArrayList;

class Graph{
    int vertices;
    ArrayList<ArrayList<Integer>> adjList;

    Graph(int v){
        vertices = v;
        adjList = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    void dfs(int start) {
        boolean[] visited = new boolean[vertices];
        dfsHelper(start, visited);
    }

    void dfsHelper(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, visited);
            }
        }
    }
}
public class DFS {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        System.out.println("Depth-First Search starting from vertex 0:");
        g.dfs(0);
        
    }
}
