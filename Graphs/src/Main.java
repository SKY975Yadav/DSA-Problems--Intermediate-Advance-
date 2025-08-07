import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int x = sc.nextInt();
//        int y = sc.nextInt();
//        if(x == y) {
//            System.out.println("Both x and y are same");
//        }
//        else if (x > y){
//            System.out.println("X is greater then Y");
//        }
//        else {
//            System.out.println("Y is greater than X ");
//        }
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        if (str1.charAt(0) == str2.charAt(0) && str1.charAt(str1.length()-1) == str2.charAt(str2.length()-1)){
            System.out.println("Yes both names are start and end with same letter");
        }
        else {
            System.out.println("No");
        }
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

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        for (int x : nums1){arr1.add(x);}
        for (int y : nums2){arr2.add(y);}

        PriorityQueue<Integer> heap1 = new PriorityQueue<>(arr1);
        PriorityQueue<Integer> heap2 = new PriorityQueue<>(arr2);

        for (int i = 0; i < k; i++){

            res.add(new ArrayList<>());
            res.get(i).add(heap1.peek());
            res.get(i).add(heap2.peek());

            if (heap1.peek() > heap2.peek()){
                heap1.poll();
            }
            else {
                heap2.poll();
            }
        }
        return res;
    }

//    public static boolean ratMaze(int [][] mat){
//        return helper(mat,0,0,mat.length,mat[0].length);
//    }
//
//    private static boolean helper(int [][] mat,int i,int j,int m,int n){
//        if (i==m-1 && j ==n-1) return true;
//        if ((i>=m || j>=n) || mat[i][j] == 0) return false;
//        return helper(mat,i+1,j,m,n) || helper(mat,i,j+1,m,n);
//    }

    public static void ratMaze(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] pathMatrix = new int[m][n]; // Initially all zeros
        if (helper(mat, 0, 0, m, n, pathMatrix)) {
            System.out.println("Path found:");
            printMatrix(pathMatrix);
        } else {
            System.out.println("No path exists.");
        }
    }

    private static boolean helper(int[][] mat, int i, int j, int m, int n, int[][] pathMatrix) {
        // Check bounds or if cell is blocked
        if (i >= m || j >= n || mat[i][j] == 0) {
            return false;
        }
        // Mark current cell as part of the path
        pathMatrix[i][j] = 1;
        // Reached destination
        if (i == m - 1 && j == n - 1) {
            return true;
        }
        // Try moving right
        if (helper(mat, i, j + 1, m, n, pathMatrix)) {
            return true;
        }
        // Try moving down
        if (helper(mat, i + 1, j, m, n, pathMatrix)) {
            return true;
        }
        // If neither right nor down leads to destination, backtrack
        pathMatrix[i][j] = 0;
        return false;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}