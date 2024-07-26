import java.util.Arrays;

public class BellmanFordAlgo {

    static class Edge {
        int source, destination, weight;
        
        Edge() {
            source = destination = weight = 0;
        }
    }

    static class Graph {
        int verticesCount, edgesCount;
        Edge[] edge;

        Graph(int verticesCount, int edgesCount) {
            this.verticesCount = verticesCount;
            this.edgesCount = edgesCount;
            edge = new Edge[edgesCount];
            for (int i = 0; i < edgesCount; ++i) {
                edge[i] = new Edge();
            }
        }
    }

    public static Graph createGraph(int verticesCount, int edgesCount) {
        return new Graph(verticesCount, edgesCount);
    }

    private static void print(int[] distance, int count) {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < count; ++i) {
            System.out.println(i + "\t\t" + distance[i]);
        }
    }

    public static void bellmanFord(Graph graph, int source) {
        int verticesCount = graph.verticesCount;
        int edgesCount = graph.edgesCount;
        int[] distance = new int[verticesCount];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        for (int i = 1; i < verticesCount; ++i) {
            for (int j = 0; j < edgesCount; ++j) {
                int u = graph.edge[j].source;
                int v = graph.edge[j].destination;
                int weight = graph.edge[j].weight;

                if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                }
            }
        }

        for (int j = 0; j < edgesCount; ++j) {
            int u = graph.edge[j].source;
            int v = graph.edge[j].destination;
            int weight = graph.edge[j].weight;

            if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                System.out.println("Graph contains negative weight cycle.");
            }
        }

        print(distance, verticesCount);
    }

    public static void main(String[] args) {
        int verticesCount = 5;
        int edgesCount = 8;
        Graph graph = createGraph(verticesCount, edgesCount);

        // Edge 0-1
        graph.edge[0].source = 0;
        graph.edge[0].destination = 1;
        graph.edge[0].weight = -1;

        // Edge 0-2
        graph.edge[1].source = 0;
        graph.edge[1].destination = 2;
        graph.edge[1].weight = 4;

        // Edge 1-2
        graph.edge[2].source = 1;
        graph.edge[2].destination = 2;
        graph.edge[2].weight = 3;

        // Edge 1-3
        graph.edge[3].source = 1;
        graph.edge[3].destination = 3;
        graph.edge[3].weight = 2;

        // Edge 1-4
        graph.edge[4].source = 1;
        graph.edge[4].destination = 4;
        graph.edge[4].weight = 2;

        // Edge 3-2
        graph.edge[5].source = 3;
        graph.edge[5].destination = 2;
        graph.edge[5].weight = 5;

        // Edge 3-1
        graph.edge[6].source = 3;
        graph.edge[6].destination = 1;
        graph.edge[6].weight = 1;

        // Edge 4-3
        graph.edge[7].source = 4;
        graph.edge[7].destination = 3;
        graph.edge[7].weight = -3;

        bellmanFord(graph, 0);
    }
}
