import java.util.*;

public class ShortestPathDijkstrasAlgorithm {

    public static void shortestPath(List<List<Edge>> graph,int source,int target){

        //declarations :
        int V = graph.size();
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        int[] dist = new int[V];
        int[] parent = new int[V];
        boolean[] finalised = new boolean[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        dist[source] = 0;
        pq.add(new Edge(source, 0));

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int u = e.dest;

            if (finalised[u]) continue;
            finalised[u] = true;

            for (Edge edge : graph.get(u)) {
                int v = edge.dest, weight = edge.weight;
                if (!finalised[v] && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    parent[v] = u;
                    pq.add(new Edge(v, dist[v]));  // Add updated distance
                }
            }
        }

        // Print shortest distances
        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("to " + i + " is : Not Possible");
            } else {
                System.out.println("to " + i + " is : " + dist[i]);
            }
        }

        // Print shortest path to target
        if (dist[target] == Integer.MAX_VALUE) {
            System.out.println("No path exists from " + source + " to " + target);
        } else {
            System.out.println("Shortest Distance from " + source + " to " + target + " is: " + dist[target]);
            System.out.print("Path: ");
            printPath(parent, source, target);
        }

    }

    private static void printPath(int[] parent, int source, int target) {
        List<Integer> path = new ArrayList<>();
        for (int v = target; v != -1; v = parent[v]) {
            path.add(v);
        }
        Collections.reverse(path);

        System.out.print(path.getFirst());
        for (int i = 1; i < path.size(); i++) {
            System.out.print(" -> " + path.get(i));
        }
        System.out.println();
    }

    // Matrix form graph

    public static int[] djikstra(int[][] graph, int src, int V)
    {

        int[] dist=new int[V];int res=0;
        Arrays.fill(dist,Integer.MAX_VALUE);dist[src]=0;
        boolean[] fin=new boolean[V];

        for (int count = 0; count < V-1 ; count++)
        {
            int u = -1;

            for(int i=0;i<V;i++)
                if(!fin[i]&&(u==-1||dist[i]<dist[u]))
                    u=i;
            fin[u] = true;

            for (int v = 0; v < V; v++)

                if (graph[u][v]!=0 && !fin[v])
                    dist[v] = Math.min(dist[v],dist[u]+graph[u][v]);
        }
        return dist;
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

        shortestPath(g.getList(),0,3);
    }
}
