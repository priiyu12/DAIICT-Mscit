import java.util.*;

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

    // Directed graph
    void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    // Step 1: Fill stack by finish time
    void fillOrder(int node, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                fillOrder(neighbor, visited, stack);
            }
        }

        stack.push(node);
    }

    // Step 2: Transpose graph
    Graph getTranspose() {
        Graph g = new Graph(vertices);

        for (int i = 0; i < vertices; i++) {
            for (int neighbor : adj.get(i)) {
                g.adj.get(neighbor).add(i);
            }
        }

        return g;
    }

    // Step 3: DFS on transpose
    void dfsPrint(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsPrint(neighbor, visited);
            }
        }
    }

    // Kosaraju Algorithm
    void kosaraju() {

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];

        // Step 1: Fill stack
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                fillOrder(i, visited, stack);
            }
        }

        // Step 2: Transpose graph
        Graph gr = getTranspose();

        Arrays.fill(visited, false);

        System.out.println("Strongly Connected Components:");

        // Step 3: Process stack
        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) {
                gr.dfsPrint(node, visited);
                System.out.println(); // new SCC
            }
        }
    }
}

// ---------------- MAIN ----------------
public class TopoDFS {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        Graph g = new Graph(v);

        System.out.println("Enter directed edges (u v):");
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int w = sc.nextInt();
            g.addEdge(u, w);
        }

        g.kosaraju();

        sc.close();
    }
}