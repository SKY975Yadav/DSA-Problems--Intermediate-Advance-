public class SortedAndRotated {
    public static void main(String[] args) {
        int [] arr = {1,10,8,9,6,3};
        System.out.println(checkArrayIsSortedAndRotated(arr,arr.length));
    }
    public static boolean checkArrayIsSortedAndRotated(int [] arr,int n){
        if (n <= 1) return true;

        int pivotAsc = 0; // For increasing order rotation
        int pivotDesc = 0; // For decreasing order rotation

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                pivotAsc++;
            }
            if (arr[i - 1] < arr[i]) {
                pivotDesc++;
            }
        }

        // Check if either increasing or decreasing rotation conditions are met
        return (pivotAsc == 1 && arr[n - 1] < arr[0]) || (pivotDesc == 1 && arr[n - 1] > arr[0]);
    }
}
