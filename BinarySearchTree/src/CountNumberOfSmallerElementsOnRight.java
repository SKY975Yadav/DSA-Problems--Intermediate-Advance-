import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class CountNumberOfSmallerElementsOnRight {
    static class TreeNode {
        int val;
        int leftCount;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.leftCount = 0;
            this.left = null;
            this.right = null;
        }
    }
    public static int[] countDistinctSmaller(int[] arr) { // It's only works for counting distinct elements
        int n = arr.length;
        if (n == 0) return new int[0];

        TreeSet<Integer> bst = new TreeSet<>();
        int[] distinctSmallerCounts = new int[n];

        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            bst.add(arr[i]);
            distinctSmallerCounts[i] = bst.headSet(arr[i]).size();
        }

        // Find the maximum count of distinct smaller elements

        return distinctSmallerCounts;
    }

    public static int[] countSmallerRight(int[] arr) { // Its also count duplicates
        int n = arr.length;
        if (n == 0) return new int[0];

        TreeSet<Integer> bst = new TreeSet<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int[] smallerCounts = new int[n];

        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            int current = arr[i];
            freqMap.put(current, freqMap.getOrDefault(current, 0) + 1);
            bst.add(current);
            smallerCounts[i] = bst.headSet(current).stream().mapToInt(freqMap::get).sum();
        }

        // Find the maximum count of distinct smaller elements

        return smallerCounts;
    }
    public static int[] countSmallerLeft(int[] arr) {
        int n = arr.length;
        if (n == 0) return new int[0];

        TreeSet<Integer> bst = new TreeSet<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int[] smallerCounts = new int[n];

        // Traverse the array from right to left
        for (int i = 0; i < n; i++) {
            int current = arr[i];
            freqMap.put(current, freqMap.getOrDefault(current, 0) + 1);
            bst.add(current);
            smallerCounts[i] = bst.headSet(current).stream().mapToInt(freqMap::get).sum();
        }

        // Find the maximum count of distinct smaller elements

        return smallerCounts;
    }
    public static int[] countGreaterRight(int[] arr) {
        int n = arr.length;
        if (n == 0) return new int[0];

        TreeSet<Integer> bst = new TreeSet<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int[] greaterCounts = new int[n];

        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            int current = arr[i];
            freqMap.put(current, freqMap.getOrDefault(current, 0) + 1);
            bst.add(current);
            int greaterCount = bst.tailSet(current).stream().mapToInt(freqMap::get).sum();
            greaterCounts[i] = greaterCount - freqMap.get(current); // Exclude current element's count
        }

        return greaterCounts;
    }
    public static int[] countGreaterLeft(int[] arr) {
        int n = arr.length;
        if (n == 0) return new int[0];

        TreeSet<Integer> bst = new TreeSet<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int[] greaterCounts = new int[n];

        // Traverse the array from left to right
        for (int i = 0; i < n; i++) {
            int current = arr[i];
            freqMap.put(current, freqMap.getOrDefault(current, 0) + 1);
            bst.add(current);
            int greaterCount = bst.tailSet(current).stream().mapToInt(freqMap::get).sum();
            greaterCounts[i] = greaterCount - freqMap.get(current); // Exclude current element's count
        }

        return greaterCounts;
    }
}
