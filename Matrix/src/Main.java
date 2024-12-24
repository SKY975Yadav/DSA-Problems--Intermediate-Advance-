//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    }

    public static void printMulArray(int[][] mulArr) {
        for (int i = 0; i < mulArr.length; i++) {
            for (int j = 0; j < mulArr[i].length; j++) {
                System.out.print(mulArr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void swapMulArray(int[][] arr, int r1, int c1, int r2, int c2) {
        int temp = arr[r1][c1];
        arr[r1][c1] = arr[r2][c2];
        arr[r2][c2] = temp;
    }

    public static void swapRows(int[][] arr, int r1, int r2) {
        int[] temp = arr[r1];
        arr[r1] = arr[r2];
        arr[r2] = temp;
    }

    public static void swapColumns(int[][] arr, int c1, int c2) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i][c1];
            arr[i][c1] = arr[i][c2];
            arr[i][c2] = temp;
        }
    }


}