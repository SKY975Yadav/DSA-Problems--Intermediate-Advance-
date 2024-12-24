import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

    }
    public static ArrayList<ArrayList<Integer>> getGraph(){
        int v = 5;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            al.add(new ArrayList<>());
        }
        AdjacencyListRepresentationOfGraph.addEdge(al,0,1);
        AdjacencyListRepresentationOfGraph.addEdge(al,0,2);
        AdjacencyListRepresentationOfGraph.addEdge(al,1,3);
        AdjacencyListRepresentationOfGraph.addEdge(al,2,3);
        AdjacencyListRepresentationOfGraph.addEdge(al,2,4);
        AdjacencyListRepresentationOfGraph.addEdge(al,3,4);

        return al;
    }
}