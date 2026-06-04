class UndirectedGraph{
    int vertices;
    int[][] adjMatrix;

    UndirectedGraph(int v){
        vertices = v;
        adjMatrix = new int[v][v];
    }

    void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
    }

    void printGraph() {
        System.out.print("  ");
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class DirectedGraph{
    int vertices;
    int[][] adjMatrix;

    DirectedGraph(int v){
        vertices = v;
        adjMatrix = new int[v][v];
    }

    void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
    }

    void printGraph() {

        System.out.print("  ");
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
class Matrix{
    public static void main(String[] args) {
        UndirectedGraph ug = new UndirectedGraph(3);
        ug.addEdge(0, 1);
        ug.addEdge(1, 2);
        ug.addEdge(0, 2);
        System.out.println("Undirected Graph:");
        ug.printGraph();

        System.out.println();

        DirectedGraph dg = new DirectedGraph(3);
        dg.addEdge(0, 1);
        dg.addEdge(1, 2);
        dg.addEdge(0, 2);
        System.out.println("Directed Graph:");
        dg.printGraph();
    }
}