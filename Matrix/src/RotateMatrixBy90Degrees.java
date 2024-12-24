public class RotateMatrixBy90Degrees {
    public static void main(String[] args) {

        int [][] mulArr =
                {       {1,2,3,4,5},
                        {6,7,8,9,10},
                        {11,12,13,14,15},
                        {16,17,18,19,20},
                        {21,22,23,24,25}
                };

        Main.printMulArray(mulArr);
        rotate90Deg(mulArr);
        Main.printMulArray(mulArr);
    }

    public static void rotate90Deg(int [][] arr){ //Matrix should be n*n then only it works , we can first transport the matrix then swap the rows or we can first swap the columns then transport the matrix

        int rows = arr.length,cols = arr[0].length;

//        int temp = cols-1;
//        for (int i = 0; i < cols/2; i++) {
//            Main.swapColumns(arr,i,temp--);
//        }

        TransportOfMatrix.transportOfMatrix(arr);
        Main.printMulArray(arr);
        int temp = rows-1;
        for (int i = 0; i < rows/2; i++) {
            Main.swapRows(arr,i,temp--);
        }


    }

}
