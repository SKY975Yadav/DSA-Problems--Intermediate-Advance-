import java.util.Arrays;

public class LargestRectangleWithAllOnes {
    public static void main(String[] args) {
        int [] [] arr = {
                {1,0,0,1},
                {0,1,1,0},
                {1,0,1,1},
                {0,1,1,1}
        };

    }
    public static int largestRectangleWithAllOnes(int [][] arr){ // Binary matrix
        // Over all Time complexity is O(C) + O(R * 2C)  = O(R*C) , over All Space Complexity is O(C) + O(C) + O(R*C) = O(R*C)
        int r = arr.length,c = arr[0].length;
        int [] temp = Arrays.copyOf(arr[0],arr[0].length);  // SC : O(C)

        int res = LargestRectangleAreaInHistogram.largestRectangleArea(temp,c); // TC : O(C) and SC : O(C) Stack

        for (int i = 0; i < r; i++) { // O(R)
            for (int j = 0; j < c; j++) { // O(C)
                if (arr[i][j] == 1){
                    temp[j] += arr[i-1][j];
                }
                else{
                    temp[j] = 0;
                }
            }
            res = Math.max(res,LargestRectangleAreaInHistogram.largestRectangleArea(temp,c)); // TC : O(C) : O(C) stack
        }
        return res;
    }

}
