public class MultiplyTheMatrix {
    public static void main(String[] args) {
        int[][] arr1 = {
                {10, 20, 30, 40},
                {13, 25, 34, 45},
                {15, 26, 37, 47},
                {18, 28, 38, 49}
        };
        int[][] arr2 = {
                {12, 30, 12},
                {17, 65, 82},
                {13, 14, 12},
                {12, 29, 18}
        };
        int [] [] res = multiplyMatrix(arr1,arr2);
        Main.printMulArray(res);
    }
    static int[][] multiplyMatrix(int[][] A, int[][] B)
    {
        // code here
        int rowsA = A.length,colsA = A[0].length;
        int rowsB = B.length,colsB = B[0].length;

        if(colsA != rowsB){
            return new int [0][0];
        }
        int [][] res = new int [rowsA][colsB];

        for(int i = 0;i<rowsA;i++){

            for(int j = 0;j<colsB;j++){

                int sum = 0;
                for(int k = 0;k<colsA;k++){

                    sum += A[i][k]*B[k][j];

                }
                res[i][j] = sum;

            }

        }
        return res;

    }
}
