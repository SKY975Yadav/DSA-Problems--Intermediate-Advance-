import java.util.ArrayList;
import java.util.Arrays;

public class SlidingWindow {
    public static void main(String[] args) {
//        int [] ar = {3,2,3,45,23,3,100};
//        System.out.println(maxSumOfConsecutiveKElements(ar,ar.length,3));
//        int[] temp = {1,2,3,0,5,6,7,8,9,10};
//        System.out.println(isSubArrayWithGivenSum(temp, temp.length,3));
//        System.out.println(subarraySum(temp,temp.length,3));
//        System.out.println(Arrays.toString(temp));
//        System.out.println(isSubArrayWithGivenSum(temp,temp.length,23));


        int [] arr = {1,4,1,1,1,1,1,0,0,0,0,0,5};
        System.out.println(maxLenOfSubArrayWithGivenSum(arr, arr.length,5));
        System.out.println(Arrays.toString(indexesOfMaxLenOfSubArrayWithGivenSum(arr, arr.length, 5)));


    }
    public static int maxSumOfConsecutiveKElements(int [] arr,int n, int k){
        if (k>n) return -1;
        int curMax = 0;
        for (int i=0;i<k;i++)
            curMax += arr[i];
        int res = curMax;
        for (int i = 1; i < n-k+1; i++) { // Or you can use i<=n-k
            curMax = curMax - arr[i-1] + arr[i+k-1];
            res = Math.max(curMax,res);
        }
        return res;
    }


    public static boolean isSubArrayWithGivenSum(int [] arr,int n,int sum){
        int curSum = 0;
        int start = 0;
        for (int end = 0; end < n;end++ ) {
            curSum += arr[end];
            while (curSum>sum && start< end){
                curSum = curSum - arr[start];
                start++;
            }
            if (sum==curSum) return true;
        }
        return false;
    }
    static ArrayList<Integer> subarraySum(int[] arr, int n, int sum)
    {
        // Your code here
        ArrayList<Integer> al = new ArrayList<>(2);
        int curSum = 0,start = 0, end;
        for (end = 0; end < n;end++ ) {
            curSum += arr[end];
            while (curSum>sum && start<end){
                curSum = curSum - arr[start];
                start++;
            }
            if (sum==curSum){
                al.add(start);
                al.add(end);
                return al;
            }
        }
        al.add(-1);
        return al;
    }
    public static int maxLenOfSubArrayWithGivenSum(int [] arr,int n,int sum){
        int curSum = 0;
        int start = 0;
        int res = Integer.MIN_VALUE;
        for (int end = 0; end < n;end++ ) {
            curSum += arr[end];
            while (curSum>sum && start< end){
                curSum = curSum - arr[start];
                start++;
            }
            if (sum==curSum) {
                res = Math.max(res,end-start+1);
            }
        }
        return res;
    }
    public static int [] indexesOfMaxLenOfSubArrayWithGivenSum(int [] arr,int n,int sum){
        int curSum = 0;
        int start = 0;
        int [] resArr = new int[2];
        boolean bol = false;
        int res = Integer.MIN_VALUE;
        for (int end = 0; end < n;end++ ) {
            curSum += arr[end];
            while (curSum>sum && start< end){
                curSum = curSum - arr[start];
                start++;
            }
            if (sum==curSum) {
                if (res<end-start+1){
                    bol = true;
                    res = end-start+1;
                    resArr[0] = start;
                    resArr[1] = end;
                }
            }
        }
        if (!bol) return new int[]{-1,-1};
        return resArr;
    }
}
