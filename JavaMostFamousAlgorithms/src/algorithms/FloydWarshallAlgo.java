public class FloydWarshallAlgo {

    public static final int cst = 9999;

    private static void print(int[][] distance, int verticesCount) {
        System.out.println("Shortest distances between every pair of vertices:");

        for (int i = 0; i < verticesCount; ++i) {
            for (int j = 0; j < verticesCount; ++j) {
                if (distance[i][j] == cst)
                    System.out.print("cst".padLeft(7));
                else
                    System.out.print(String.valueOf(distance[i][j]).padLeft(7));
            }
            System.out.println();
        }
    }

    public static void floydWarshall(int[][] graph, int verticesCount) {
        int[][] distance = new int[verticesCount][verticesCount];

        // Initialize distance matrix with the given graph
        for (int i = 0; i < verticesCount; ++i)
            System.arraycopy(graph[i], 0, distance[i], 0, verticesCount);

        // Applying Floyd-Warshall algorithm
        for (int k = 0; k < verticesCount; ++k) {
            for (int i = 0; i < verticesCount; ++i) {
                for (int j = 0; j < verticesCount; ++j) {
                    if (distance[i][k] + distance[k][j] < distance[i][j])
                        distance[i][j] = distance[i][k] + distance[k][j];
                }
            }
        }

        print(distance, verticesCount);
    }

    public static void main(String[] args) {
        int[][] graph = {
                { 0,   6,  cst, 11 },
                { cst, 0,   4, cst },
                { cst, cst, 0,   2 },
                { cst, cst, cst, 0 }
        };

        floydWarshall(graph, 4);
    }
}
