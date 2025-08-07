import java.util.*;

public class KosarajuAlgorithmForSCC {
    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        addEdgeForDirect(adj,0,1);
        addEdgeForDirect(adj,1,2);
        addEdgeForDirect(adj,2,0);
        addEdgeForDirect(adj,3,1);
        addEdgeForDirect(adj,3,4);

        kosaraju(adj);
    }
    public static void addEdgeForDirect(List<List<Integer>> adj,int u,int v){
        adj.get(u).add(v);
    }

    public static void kosaraju(List<List<Integer>> adj){
        int V = adj.size();
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();

        //First DFS Ordering by Finish Time (Descending)
        for (int i = 0; i < V; i++) {
            if (!visited[i]){
                dfs1(adj,visited,i,st);
            }
        }

        // Transport of Graph
        // Step 2: Transpose the Graph
        List<List<Integer>> transpose = new ArrayList<>(V);
        for (int i = 0; i < V; i++)
            transpose.add(new ArrayList<>());

        for (int i = 0; i < V; i++) {
            for (Integer v : adj.get(i)) {
                transpose.get(v).add(i);  // Reverse the edges
            }
        }

        // Second Dfs Processing in Reverse Order
        visited = new boolean[V];
        while (!st.isEmpty()) {
            int v = st.pop();
            if (!visited[v]) {
                dfs2(transpose, visited, v);
                System.out.println();
            }
        }
    }

    private static void dfs1(List<List<Integer>> adj, boolean [] visited, int s, Stack<Integer> st){
        visited[s] = true;
        for (Integer v : adj.get(s)){
            if (!visited[v]){
                dfs1(adj,visited,v,st);
            }
        }
        st.push(s);
    }
    private static void dfs2(List<List<Integer>> adj, boolean [] visited, int s){
        visited[s] = true;
        System.out.print(s+" ");
        for (Integer v : adj.get(s)){
            if (!visited[v]){
                dfs2(adj,visited,v);
            }
        }
    }
}
