public class SpiralTraversalOfMatrix {
    public static void main(String[] args) {
        int[][] mulArr =
                {{1, 2, 3, 4, 5, 100, 120, 150, 180},
                        {6, 7, 8, 9, 10, 200, 220, 250, 280},
                        {11, 12, 13, 14, 15, 300, 320, 350, 380},

                };

        spiralTraversalOfMatrix(mulArr);
    }

    public static void spiralTraversalOfMatrix(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++) {
                System.out.print(arr[top][i] + " ");
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                System.out.print(arr[i][right] + " ");
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(arr[bottom][i] + " ");
                }
                bottom--;
            }
            if (left<=right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(arr[i][left] + " ");
                }
                left++;
            }

        }
    }
}
