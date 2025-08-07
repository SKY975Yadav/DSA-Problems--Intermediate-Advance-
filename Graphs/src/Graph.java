import java.util.ArrayList;
import java.util.List;

public class Graph{
    private List<List<Edge>> adjacencyList;
    public Graph(int vertices) {
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }
    public void addEdge(int src, int dest, int weight) {
        adjacencyList.get(src).add(new Edge(dest, weight));
        adjacencyList.get(dest).add(new Edge(src, weight)); // Since the graph is undirected
    }
    public List<List<Edge>> getList(){
        return adjacencyList;
    }
}
