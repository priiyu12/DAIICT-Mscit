import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

    void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.add(start);

        while(!q.isEmpty()){
            int node = q.poll();
            System.out.print(node + " ");

            for(int neighbor : adjList.get(node)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    q.add(neighbor);

                }
            }
        }
    }
}
public class BFS {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        System.out.println("Breadth-First Search starting from vertex 0:");
        g.bfs(0);
    }
}
