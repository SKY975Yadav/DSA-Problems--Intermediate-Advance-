import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_TraversalOfGraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = Main.getGraph();
        System.out.println(graph);
        bfs1(graph,4);
        System.out.println();
        bfs2(graph);
    }
    public static void bfs1(ArrayList<ArrayList<Integer>> graph,int s){ // Given source vertex . Traverse bfs from the given source, for connected graph
        int noOfVertices = graph.size();
        boolean [] visited = new boolean[noOfVertices];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        while (!queue.isEmpty()){
            int u = queue.poll();
            System.out.print(u + " ");
            for (int vertex : graph.get(u)) {
                if (!visited[vertex]) {
                    queue.add(vertex);
                    visited[vertex] = true;
                }
            }
        }
    }

    public static void bfs2(ArrayList<ArrayList<Integer>> graph){ // For un connected graph and Will not give any source
        int noOfVertices = graph.size();
        boolean [] visited = new boolean[noOfVertices];

        // int count = 0; for count all connected

        for (int i = 0; i < noOfVertices; i++) {

            if (!visited[i]){
                bfs2Helper(graph,i,visited);
                //count++
            }

        }
        //return count;
    }
    private static void bfs2Helper(ArrayList<ArrayList<Integer>> graph,int s,boolean [] visited){ // Given source vertex . Traverse bfs from the given source
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        queue.add(graph.get(s));
        System.out.print(s+" ");
        visited[s] = true;
        while (!queue.isEmpty()){
            ArrayList<Integer> temp = queue.poll();
            for (int v : temp) {
                if (!visited[v]) {
                    System.out.print(v + " ");
                    queue.add(graph.get(v));
                    visited[v] = true;
                }
            }
        }
    }
}
