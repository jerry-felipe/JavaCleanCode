import java.util.*;

public class Dijkstra {

    private static int MinimumDistance(int[] distance, boolean[] shortestPathTreeSet, int verticesCount) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < verticesCount; ++v) {
            if (!shortestPathTreeSet[v] && distance[v] <= min) {
                min = distance[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    private static void Print(int[] distance, int verticesCount) {
        System.out.println("Vertex    Distance from source");

        for (int i = 0; i < verticesCount; ++i)
            System.out.println(i + "\t  " + distance[i]);
    }

    public static void DijkstraAlgo(int[][] graph, int source, int verticesCount) {
        int[] distance = new int[verticesCount];
        boolean[] shortestPathTreeSet = new boolean[verticesCount];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(shortestPathTreeSet, false);

        distance[source] = 0;

        for (int count = 0; count < verticesCount - 1; ++count) {
            int u = MinimumDistance(distance, shortestPathTreeSet, verticesCount);
            shortestPathTreeSet[u] = true;

            for (int v = 0; v < verticesCount; ++v)
                if (!shortestPathTreeSet[v] && graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE && distance[u] + graph[u][v] < distance[v])
                    distance[v] = distance[u] + graph[u][v];
        }

        Print(distance, verticesCount);
    }

    public static void main(String[] args) {
        int[][] graph = {
                { 0, 6, 0, 0, 0, 0, 0, 9, 0 },
                { 6, 0, 9, 0, 0, 0, 0, 11, 0 },
                { 0, 9, 0, 5, 0, 6, 0, 0, 2 },
                { 0, 0, 5, 0, 9, 16, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 6, 0, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 16, 0, 2, 0, 1, 6 },
                { 9, 11, 0, 0, 0, 0, 1, 0, 5 },
                { 0, 0, 2, 0, 0, 0, 6, 5, 0 }
        };

        DijkstraAlgo(graph, 0, 9);
    }
}
