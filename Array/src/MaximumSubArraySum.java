import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSubArraySum {

    public static void main(String[] args) {
        int[] a = {16 ,-1, 28, -24, 1, -3, 5 ,-23 ,19};
        System.out.println(Arrays.toString(a));
        System.out.println(maxCircularSubArraySum(a,a.length));
//        System.out.println(maximum_subarrayContainAtMostOneSquare(a));
//        System.out.println(minSubArraySum(a,a.length));
//        System.out.println(maxCircularSubArraySum(a,a.length));
    }
    public static int maxSubArraySum(int [] arr,int n){ //Kadane's

        int res = arr[0];
        int curMaxSum = arr[0];
        for (int i = 1; i < n; i++) {
            curMaxSum = Math.max(curMaxSum+arr[i],arr[i]);
            res = Math.max(curMaxSum,res);
        }
        return res;
    }
    public static long maximum_subarrayContainAtMostOneSquare(int [] arr){
        int n = arr.length;
        int max = 0;
        long ans = 0;
        int [] left = new int[n+1];
        int [] right = new int[n+1];
        left[0] = 0;
        right[n] = 0;
        for (int i = 0; i < n; i++) {
            max = max + arr[i];
            if (max<0) max = 0;
            left[i+1] = max;
        }
        max=0;
        for (int i = n-1; i >= 0; i--) {
            max = max + arr[i];
            if (max<0) max = 0;
            right[i] = max;
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        for (int i=0;i<n;i++){
            ans = Math.max(ans, (long) arr[i] *arr[i] + left[i]+right[i+1]);
        }
        return ans;
    }
    public static int minSubArraySum(int [] arr,int n){ //Kadane's
        int res = arr[0];
        int curMaxSum = arr[0];
        for (int i = 1; i < n; i++) {
            curMaxSum = Math.min(curMaxSum+arr[i],arr[i]);
            res = Math.min(curMaxSum,res);
        }
        return res;
    }
    public static int maxCircularSubArraySum(int [] arr,int n){
        int maxSum = maxSubArraySum(arr,n);
        if (maxSum<0) return maxSum; //If all are negative then this maxSubArray method will give the largest element in -ve
        int totalArraySum = 0;
        for (int i = 0; i < n; i++) {
            totalArraySum += arr[i];
        }

        int minSum = minSubArraySum(arr,n);
        System.out.println("max Sum : "+maxSum);
        System.out.println("Total Sum : "+totalArraySum);
        System.out.println("min Sum : "+minSum);
        return Math.max(totalArraySum-minSum,maxSum);
    }

}
