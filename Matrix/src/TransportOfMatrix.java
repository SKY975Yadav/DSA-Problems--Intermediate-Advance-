public class TransportOfMatrix {
    public static void main(String[] args) {
        int [][] mulArr =
                {       {1,2,3,4,5},
                        {6,7,8,9,10},
                        {11,12,13,14,15},
                        {16,17,18,19,20},
                        {21,22,23,24,25}
                };

        Main.printMulArray(mulArr);
        transportOfMatrix(mulArr);
        System.out.println();
        Main.printMulArray(mulArr);

    }
    static void transportOfMatrix(int [][] arr){ //It works only for n*n matrix
        int m= arr.length,n = arr[0].length;

        for (int i = 0; i <  m; i++) {
           for (int j = i+1; j < n; j++) {
               Main.swapMulArray(arr,i,j,j,i);
           }
        }

    }

    public static int[][] transposeMatrix(int[][] matrix) { // It works for m*n Matrix
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] transposedMatrix = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        return transposedMatrix;
    }
}
