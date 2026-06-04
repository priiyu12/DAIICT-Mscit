import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Graph {
    int vertices;
    ArrayList<ArrayList<Integer>> adj;

    Graph(int v) {
        vertices = v;
        adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Directed graph edge
    void addEdge(int u, int v) {
        adj.get(u).add(v);
    }
    void topologicalSortBFS() {

        int[] indegree = new int[vertices];

        // Step 1: calculate indegree
        for (int i = 0; i < vertices; i++) {
            for (int neighbor : adj.get(i)) {
                indegree[neighbor]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // Step 2: add nodes with indegree 0
        for (int i = 0; i < vertices; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0; // for cycle detection

        System.out.print("BFS Topo Sort: ");

        // Step 3: process queue
        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            count++;

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // Step 4: cycle detection
        if (count != vertices) {
            System.out.println("\nCycle exists! Topological sort not possible.");
        } else {
            System.out.println();
        }
    }
}

// ---------------- MAIN FUNCTION ----------------
public class TopologicalSort {
    public static void main(String[] args) {

        Graph g = new Graph(6);

        // Example DAG
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        g.topologicalSortBFS();
    }
}