import java.util.Arrays;

public class KthSmallestAndKthLargest {
    public static void main(String[] args) {
        int [] i = {2,6,54,12,13,52,12,12,46,53,12};

        System.out.println(kthSmallestElement(i,4));
//        System.out.println(kthLargestElement(i,6));
        System.out.println(kthSmallestElementUsingQuickSelect(i, i.length, 4));

    }

    //My Solution : O(n log n) + O(n) = O(n Log n)
    public static int kthSmallestElement(int []ar , int k){
        Arrays.sort(ar);
        if (k==1) return ar[0];
        int x = 1;
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] == ar[i - 1]) {
                continue;
            }
            x++;
            if (x == k) {
                return ar[i];
            }
        }
        return Integer.MIN_VALUE;
    }
    public static int kthLargestElement(int[]ar,int k){
        Arrays.sort(ar);
        if (k==1) return ar[ar.length-1];
        int x = 1;
        for (int i = ar.length-2; i >=0; i--) {
            if (ar[i] == ar[i + 1 ]) {
                continue;
            }
            x++;
            if (x == k) {
                return ar[i];
            }
        }
        return Integer.MIN_VALUE;
    }

    // Best solution in O(n) time on average worst case O(n^2) but still works mostly on O(n) time
    public static int kthSmallestElementUsingQuickSelect(int [] arr,int n,int k){ // Works only for distinct elements
        int l = 0,r = n-1;
        while (l <= r) {
            int pivot = lomutoPartition(arr, l, r);
            if (pivot == k-1) return arr[pivot];
            if (pivot < k-1){
                l = pivot+1;
            }
            else r = pivot-1;
        }
        return -1;
    }
    public  static int lomutoPartition(int [] arr,int l,int r) {
        int pivot = arr[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (arr[j] < pivot) {    // change <   to   > if we want Kth largest
                i++;
                Swap.swapArray(arr, i, j);
            }
        }
        Swap.swapArray(arr, i + 1, r);
        return i + 1;
    }
}
