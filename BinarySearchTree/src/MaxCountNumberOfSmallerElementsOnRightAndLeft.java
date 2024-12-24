import java.util.*;

public class MaxCountNumberOfSmallerElementsOnRightAndLeft {
    public static void main(String[] args) {
        //only works for distinct
    }
    static int countSmallerRight(int[] arr, int n){
        if (n == 0) return 0;

        TreeSet<Integer> bst = new TreeSet<>();
        int maxDistinctSmaller = 0;

        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            bst.add(arr[i]);
            maxDistinctSmaller = Math.max(maxDistinctSmaller, bst.headSet(arr[i]).size());
        }
        return maxDistinctSmaller;
    }
    static int countSmallerLeft(int[] arr, int n){
        if (n == 0) return 0;

        TreeSet<Integer> bst = new TreeSet<>();
        int maxDistinctSmaller = 0;

        // Traverse the array from right to left
        for (int i = 0; i < n; i++) {
            bst.add(arr[i]);
            maxDistinctSmaller = Math.max(maxDistinctSmaller, bst.headSet(arr[i]).size());
        }
        return maxDistinctSmaller;
    }

}
