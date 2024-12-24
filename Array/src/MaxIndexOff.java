import java.util.Arrays;

public class MaxIndexOff {
    public static void main(String[] args) {
        int [] ar = {9,4,3,2};
        System.out.println(maxIndexDiff(ar,ar.length));

    }


    //Statement :
    /*
        Given an array a of n positive integers. The task is to find the maximum of j - i subjected to the constraint of a[i] < a[j] and i < j.

    Example 2:

    Input:
    n = 9
    a[] = {34, 8, 10, 3, 2, 80, 30, 33, 1}
    Output:
    6
    Explanation:
    In the given array a[1] < a[7] satisfying the required condition(a[i] < a[j]) thus giving the maximum difference of j - i which is 6(7-1).
    Your Task:
    The task is to complete the function maxIndexDiff() which takes array a[] and integer n as input and returns the maximum index difference.

    Expected Time Complexity: O(N)
    Expected Auxiliary Space: O(N)
     */
    public static int maxIndOff(int[] arr, int n) { // it O(n^2) TC
        int res = 0;
        for (int i = 0; i < n-1; i++) {
            if (res >= (n-i)) return res;
            for (int j = n-1; j >i; j--) {
                if (arr[j]>arr[i]){
                    res = Math.max(res,j-i);
                    break;
                }
            }
        }
        return res;
    }

    public static int maxIndexDiff(int[] arr, int n) {
        if (n == 0) return 0;

        int[] leftMin = new int[n];
        int[] rightMax = new int[n];

        // Populate leftMin array
        leftMin[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(arr[i], leftMin[i - 1]);
        }

        // Populate rightMax array
        rightMax[n - 1] = arr[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            rightMax[j] = Math.max(arr[j], rightMax[j + 1]);
        }

        // Traverse both arrays to find the maximum difference
        System.out.println(Arrays.toString(leftMin));
        System.out.println(Arrays.toString(rightMax));
        int i = 0, j = 0, maxDiff = -1;
        while (i < n && j < n) {
            if (leftMin[i] <= rightMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            } else {
                i++;
            }
        }

        return maxDiff;
    }
}
