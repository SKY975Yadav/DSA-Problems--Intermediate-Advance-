public class BooleanMatrix {
    public static void main(String[] args) {

        int[][] arr = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 1}
        };
        Main.printMulArray(arr);
        booleanMatrix(arr);
        Main.printMulArray(arr);
    }
    /*
    Given a boolean matrix of size RxC where each cell contains either 0 or 1, modify it such that if a matrix cell
    matrix[i][j] is 1 then all the cells in its ith row and jth column will become 1.
     */
    static void booleanMatrix(int[][] matrix)
    {
        // code here
        int r = matrix.length,c = matrix[0].length;

        int [] rows = new int[r],cols = new int[c];

        for(int i = 0; i < r; i++){

            for(int j = 0; j < c; j++){

                if(matrix[i][j]==1){
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }

        }

        for(int i = 0; i < r; i++){

            for(int j = 0; j < c; j++){

                if(rows[i]==1 || cols[j]==1){

                    matrix[i][j] = 1;

                }
            }

        }

    }
}
