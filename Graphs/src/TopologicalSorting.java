import java.util.*;

public class TopologicalSorting {
    public static void main(String[] args) {

    }
    public static void topologicalSortingBFS(ArrayList<ArrayList<Integer>> adj){ // Khans Algorithm
        int V = adj.size();
        int[] inDegree = new int[V];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        // Compute in-degrees of all vertices
        for (ArrayList<Integer> edges : adj) {
            for (int node : edges) {
                inDegree[node]++;
            }
        }

        // Enqueue all vertices with in-degree 0
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        // Process the queue
        while (!q.isEmpty()) {
            int curr = q.poll();
            result.add(curr);

            // Reduce in-degree of neighbors and enqueue if in-degree becomes 0
            for (int neighbor : adj.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // Print the topological order , // Cycle detection
        if (result.size() != V) {
            System.out.println("Cycle detected! Topological sorting not possible.");
        } else {
            System.out.println("Topological Order: " + result);
        }
    }
    public static void topologicalSortingDfS(ArrayList<ArrayList<Integer>> graph){
        int noOfVertices = graph.size();
        boolean [] visited = new boolean[noOfVertices];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < noOfVertices; i++) {
            if (!visited[i]){
                dfsTopSort(graph,i,visited,st);
            }
        }

        // Print topological order by popping from stack
        System.out.print("Topological Order: ");
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    private static void dfsTopSort(ArrayList<ArrayList<Integer>> graph,int s,boolean [] visited,Stack<Integer> st){
        visited[s] = true;
        for (int v : graph.get(s)) {
            if (!visited[v]){
                dfsTopSort(graph,v,visited,st);
            }
        }
        st.push(s);
    }

}
