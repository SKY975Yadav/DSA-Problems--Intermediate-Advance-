import java.util.*;

public class ShortestPathInDAG {
    public static void main(String[] args) {
        int V = 6;  // Number of vertices
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Sample DAG edges: (u, v, weight)
        addEdge(graph, 0, 1, 5);
        addEdge(graph, 0, 2, 3);
        addEdge(graph, 1, 3, 6);
        addEdge(graph, 1, 2, 2);
        addEdge(graph, 2, 4, 4);
        addEdge(graph, 2, 5, 2);
        addEdge(graph, 2, 3, 7);
        addEdge(graph, 3, 5, 1);
        addEdge(graph, 4, 5, 3);

        int source = 1;
        int target = 4;
        findShortestPath(graph, V, source, target);
    }

    // Function to add a directed edge with weight
    private static void addEdge(ArrayList<ArrayList<int[]>> graph, int u, int v, int weight) {
        graph.get(u).add(new int[]{v, weight});
    }

    public static void findShortestPath(ArrayList<ArrayList<int[]>> graph, int V, int source, int target) {
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];

        // Topological Sorting
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsTopSort(graph, i, visited, st);
            }
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;  // FIXED: Set source distance to 0

        int[] parent = new int[V];  // Store path
        Arrays.fill(parent, -1);

        // Process vertices in topological order
        while (!st.isEmpty()) {
            int u = st.pop();
            if (dist[u] != Integer.MAX_VALUE) {
                for (int[] edge : graph.get(u)) {
                    int v = edge[0], weight = edge[1];
                    if (dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        parent[v] = u;
                    }
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

    private static void dfsTopSort(ArrayList<ArrayList<int[]>> graph, int s, boolean[] visited, Stack<Integer> st) {
        visited[s] = true;
        for (int[] edge : graph.get(s)) {
            int v = edge[0];
            if (!visited[v]) {
                dfsTopSort(graph, v, visited, st);
            }
        }
        st.push(s);
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
}
