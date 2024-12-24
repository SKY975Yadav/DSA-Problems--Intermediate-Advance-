public class DeterminantOfMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {10, 20, 30, 40},
                {13, 25, 34, 45},
                {15, 26, 37, 47},
                {18, 28, 38, 49}
        };
        System.out.println(determinantOfMatrix(arr, arr.length));
    }
    static int determinantOfMatrix(int[][] matrix, int n)
    {
        // code here
        if(n==1){
            return matrix[0][0];
        }
        if(n==2){
            int mul1 = matrix[0][0] * matrix[1][1];
            int mul2 = matrix[0][1] * matrix[1][0];

            return mul1-mul2;
        }

        int res = 0;
        for(int i = 0;i<n;i++){

            int [][] recMatrix = extractFun(matrix,n,i);
            res += (int) (Math.pow(-1, i) * matrix[0][i]*(determinantOfMatrix(recMatrix,n-1)));

        }

        return res;

    }

    static int[][] extractFun(int[][] matrix, int n, int skipCol){

        int[][] ans = new int[n-1][n-1];

        for (int i = 1; i < n; i++) { // Start from the second row
            int k = 0;
            for (int j = 0; j < n; j++) {
                if (j != skipCol) {
                    ans[i-1][k++] = matrix[i][j];
                }
            }
        }

        return ans;

    }
}
