import java.util.*;

public class NumberOfTrianglesInGivenArray {
    public static void main(String[] args) {
        int[] arr = {12, 34, 34, 23, 21, 8, 12, 23, 32};
        System.out.println(findNumberOfTriangles(arr, arr.length));
    }

    static int findNumberOfTriangles(int[] arr, int n) {
        //Logic a triplet said to be triangle if any one of this condition is true : a + b > c || a + c > b || c + b > a
        // To solve this first sort the array then traverse from last element consider this element as lesser element ,
        // find the pair that is the pair sum is greater then this element then that is a triangle. then increment count

        // We first sort the array to achieve this efficiently if arr[l] + arr[r] > arr[i] then all the elements from
        // l to r also satisfy this condition we can assume that all the elements from left to right as arr[l] then we sum with arr[r] then it always greater than arr[i]
        // code here

        Arrays.sort(arr);
        int count = 0;

        // Fix the third element one by one
        for (int i = n - 1; i >= 1; i--) {
            int l = 0;  // Start pointer
            int r = i - 1;  // End pointer

            while (l < r) {
                // If arr[l] + arr[r] > arr[i], then we found a valid triplet
                if (arr[l] + arr[r] > arr[i]) {
                    // All elements between l and r form a valid triplet with arr[i]
                    count += (r - l);
                    r--;  // Move the end pointer left
                } else {
                    l++;  // Move the start pointer right
                }
            }
        }

        return count;
    }
}
