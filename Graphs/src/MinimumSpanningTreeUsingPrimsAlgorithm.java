import java.util.*;

public class MinimumSpanningTreeUsingPrimsAlgorithm {

    public static void primMST(List<List<Edge>> adjacencyList) {
        int vertices = adjacencyList.size();
        boolean[] visited = new boolean[vertices];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        List<Edge> mstEdges = new ArrayList<>();

        pq.add(new Edge(0, 0)); // Start with vertex 0

        int totalWeight = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            if (visited[current.dest]) continue;

            visited[current.dest] = true;
            totalWeight += current.weight;

            if (current.weight != 0) mstEdges.add(current);

            for (Edge neighbor : adjacencyList.get(current.dest)) {
                if (!visited[neighbor.dest]) {
                    pq.add(neighbor);
                }
            }
        }

        System.out.println("Minimum Spanning Tree Edges:");
        for (Edge edge : mstEdges) {
            System.out.println(edge.dest + " - " + edge.weight);
        }
        System.out.println("Total Weight of MST: " + totalWeight);
    }

    // Matrix form :
    public static int primMST(int[][] graph, int V)
    {

        int[] key=new int[V];int res=0;
        Arrays.fill(key,Integer.MAX_VALUE);
        boolean[] mSet=new boolean[V]; key[0]=0;

        for (int count = 0; count < V ; count++)
        {
            int u = -1;

            for(int i=0;i<V;i++)
                if(!mSet[i]&&(u==-1||key[i]<key[u]))
                    u=i;
            mSet[u] = true;
            res+=key[u];


            for (int v = 0; v < V; v++)

                if (graph[u][v]!=0 && !mSet[v])
                    key[v] = Math.min(key[v],graph[u][v]);
        }
        return res;
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 3, 6);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 8);
        g.addEdge(1, 4, 5);
        g.addEdge(2, 4, 7);
        g.addEdge(3, 4, 9);

        MinimumSpanningTreeUsingPrimsAlgorithm.primMST(g.getList());
    }
}
