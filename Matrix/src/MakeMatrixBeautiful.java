public class MakeMatrixBeautiful {
    public static void main(String[] args) {
        int[][] arr = {
                {10, 20, 30, 40},
                {13, 25, 34, 45},
                {15, 26, 37, 47},
                {18, 28, 38, 49}
        };
        System.out.println(findMinOperation(arr.length,arr));

    }

    public static int findMinOperation(int n, int[][] matrix) {
        // code here

        int[] rowSums = new int[n];
        int[] colSums = new int[n];
        int maxSum = Integer.MIN_VALUE;

        // Calculate row sums and column sums, and find the maximum sum
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSums[i] += matrix[i][j];
                colSums[j] += matrix[i][j];
            }
        }

        // Find the maximum sum among all row sums and column sums
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, rowSums[i]);
            maxSum = Math.max(maxSum, colSums[i]);
        }

        int operations = 0;

        // Calculate the total number of operations required
        for (int i = 0; i < n; i++) {
            operations += (maxSum - rowSums[i]);
        }

        return operations;
    }

}
