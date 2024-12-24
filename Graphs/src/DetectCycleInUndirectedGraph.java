import java.util.ArrayList;
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
}
