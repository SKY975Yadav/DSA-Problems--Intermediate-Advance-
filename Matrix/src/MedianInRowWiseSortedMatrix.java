import java.util.Arrays;

public class MedianInRowWiseSortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 4, 10, 24, 30, 34, 35, 40, 45},
                {3, 7, 13, 19, 29, 32, 37, 41, 47},
                {2, 20, 21, 25, 33, 38, 39, 42, 50}
        };
        System.out.println(medianOFRowWiseSortedMatrix(arr));
    }

    public static int medianOFRowWiseSortedMatrix(int[][] arr) {
        int row = arr.length, col = arr[0].length;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int i = 0; i < row; i++) {
            max = Math.max(max, arr[i][col - 1]);
            min = Math.min(min, arr[i][0]);
        }

        int medPos = (row * col + 1) / 2;
        while (min < max) {
            int mid = (max + min) / 2, midPos = 0;

            for (int i = 0; i < row; i++) {
                int pos = Arrays.binarySearch(arr[i], mid) + 1;
                midPos += Math.abs(pos);
            }
//            System.out.println("Min : "+min+" Max : "+max);
//            System.out.println(mid+" "+midPos);
            if (midPos < medPos) {
                min = mid+1;
            } else max = mid;
        }
        return min;
    }
}
