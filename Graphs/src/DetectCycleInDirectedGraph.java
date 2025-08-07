import java.util.ArrayList;

public class DetectCycleInDirectedGraph {
    public static void main(String[] args) {

    }
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V = adj.size();
        boolean [] visited = new boolean[V];
        boolean [] recVis = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!visited[i]){
                if(recDfs(adj,visited,recVis,i)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean recDfs(ArrayList<ArrayList<Integer>> adj, boolean [] visited, boolean [] recVis, int s){
        visited[s] = true;
        recVis[s] = true;

        for(int u : adj.get(s)){
            if(!visited[s] && recDfs(adj,visited,recVis,u)){
                return true;
            }
            else if(recVis[u]){
                return true;
            }
        }
        recVis[s] = false;
        return false;
    }
}
