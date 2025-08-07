import java.util.ArrayList;

public class DFS_TraversalOfGraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = Main.getGraph();
        dfs1(graph,3);
        System.out.println();
        dfs2(graph);
    }
    public static void dfs1(ArrayList<ArrayList<Integer>> graph,int s){
        int noOfVertices = graph.size();
        boolean [] visited = new boolean[noOfVertices];
        dfs1Helper(graph,s,visited);
    }
    private static void dfs1Helper(ArrayList<ArrayList<Integer>> graph,int s,boolean [] visited){
        visited[s] = true;
        System.out.print(s+" ");
        for (int v : graph.get(s)) {
            if (!visited[v]){
                dfs1Helper(graph,v,visited);
            }
        }
    }
    public static void dfs2(ArrayList<ArrayList<Integer>> graph){
        int noOfVertices = graph.size();
        boolean [] visited = new boolean[noOfVertices];
        // int count = 0; for count all connected

        for (int i = 0; i < noOfVertices; i++) {
            if (!visited[i]){
                dfs1Helper(graph,i,visited);
                //count++
            }
        }
        //return count;
    }
}
