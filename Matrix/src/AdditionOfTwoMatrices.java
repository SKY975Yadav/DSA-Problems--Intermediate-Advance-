public class AdditionOfTwoMatrices {
    public static void main(String[] args) {

    }
    static int[][] sumMatrix(int A[][], int B[][])
    {
        // code here
        int row1 = A.length;
        int col1 = A[0].length;
        int row2 = B.length;
        int col2 = B[0].length;

        if(row1 != row2 || col1 !=col2){
            return new int [0][0];
        }

        int [][] res = new int[row1][col1];

        for(int i = 0;i<row1;i++){
            for(int j = 0;j<col1;j++){
                res[i][j] = A[i][j] + B[i][j];
            }
        }

        return res;

    }
}
