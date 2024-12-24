import java.util.Arrays;

public class AdjacencyMatrixRepresentationOfGraph {
    public static void main(String[] args) {
        int [] [] graph = {
                /*
                (0)
                    \
               (1)---(2)
                \
                 (3)
                 */
                {0,0,1,0},
                {0,0,1,1},
                {1,1,0,0},
                {0,1,0,0}
        };

        System.out.println(Arrays.toString(graph[2])); // Edges from node 2
    }
}
