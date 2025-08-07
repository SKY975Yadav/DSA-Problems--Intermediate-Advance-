import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInUndirectedGraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = Main.getGraph();
        System.out.println(detectCycleInUndirectedGraph(graph));
    }
    public static boolean detectCycleInUndirectedGraph(ArrayList<ArrayList<Integer>> graph){
        int v = graph.size();
        boolean [] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]){
                if (recFun(graph,visited,i,-1)) return true;
            }
        }
        return false;
    }

    private static boolean recFun(ArrayList<ArrayList<Integer>> graph,boolean[] visited,int s, int parent){
        visited[s] = true;
        for (int u : graph.get(s)) {
            if (!visited[u]){
                if (recFun(graph, visited, u, s)) return true;
            } else if (u != parent) return true;
        }
        return false;
    }

    // BFS-based cycle detection
    public boolean hasCycle(ArrayList<ArrayList<Integer>> graph,int V) {
        boolean[] visited = new boolean[V];

        // Check each component (in case of disconnected graph)
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfsCycleCheck(graph,i, visited)) {
                    return true; // Cycle detected
                }
            }
        }
        return false; // No cycle found
    }

    private boolean bfsCycleCheck(ArrayList<ArrayList<Integer>> graph,int start, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, -1}); // {node, parent}
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int node = pair[0], parent = pair[1];

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, node});
                } else if (neighbor != parent) {
                    return true; // Cycle detected
                }
            }
        }
        return false;
    }

}
