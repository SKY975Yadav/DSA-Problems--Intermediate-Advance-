public class MinimumAdjacencyDifference {
    public static void main(String[] args) {
        int [] ar = {12,4,-2,13,-32,12,-52,-1};
        System.out.println(minAdjDiff(ar));
    }
    public static int minAdjDiff(int arr[]) {

        // Your code here
        if (arr.length<2) return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1;i<arr.length;i++){
            min = Math.min(min,  Math.abs(arr[i] - arr[i-1]) );
        }
        return Math.min(min,  Math.abs(arr[arr.length-1] - arr[0]) );
    }
}
