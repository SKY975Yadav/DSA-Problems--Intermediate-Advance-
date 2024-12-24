import java.util.Arrays;

class Pair{
    int i,j;
    Pair(int i,int j){
        this.i = i;
        this.j = j;
    }
}
public class PairWithGivenSumTwoPointersApproach {
    public static void main(String[] args) {
//        int [] arr = {2,4,6,11,24,34,35,45,67,70,79,89};
//        System.out.println(isPairWithGivenSum(arr, arr.length,10));
        int [] temp = {3, 2, 10, 4, 40};
        System.out.println(Arrays.binarySearch(temp,4));
        System.out.println(closer(temp, temp.length,2));
    }
    public static boolean isPairWithGivenSum(int [] arr,int n,int x){ // Array is Sorted
        int i=0,j=n-1;
        while (i<j){
            if (arr[i]+arr[j]== x) return true;
            else if (arr[i]+arr[j]>x)
                j = j-1;
            else i = i+1;
        }
        return false;
    }
    public static boolean isPairWithGivenSum(int [] arr,int low,int high,int x){ // Array is Sorted
        int i=low,j=high;
        while (i<j){
            if (arr[i]+arr[j]== x) return true;
            else if (arr[i]+arr[j]>x)
                j = j-1;
            else i = i+1;
        }
        return false;
    }

    static long closer(int arr[], int n, long x)
    {
        // add your code here
        int ans = Arrays.binarySearch(arr,(int)x);
        return ans < 0 ? -1:ans;
    }
}
