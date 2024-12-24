public class MaxDifferenceInPair {
    public static void main(String[] args) {
        int [] arr = {3,5,23,12,5,28,12};
//        System.out.println(maxDifferenceInPair(arr));
        int [] temp = {2,4};
        System.out.println(maxProductDifference(temp));
    }
    public static int maxProductDifference(int[] arr) {
        int n = arr.length;
        if(n<2) return -1;
        if (n==2) return 0;
        int [] maxProduct = new int [n];
        maxProduct[0] = arr[0];
        maxProduct[1] = arr[0] * arr[1];
        int max = Math.max(arr[0],arr[1]);
        for(int i=2;i<n;i++){
            maxProduct[i] = arr[i] * max;
            max = Math.max(arr[i],max);
        }
        int [] minProduct = new int [n];
        minProduct[0] = arr[0];
        minProduct[1] = arr[0] * arr[1];
        int min = Math.min(arr[0],arr[1]);
        for(int i=2;i<n;i++){
            minProduct[i] = arr[i] * min;
            min = Math.min(arr[i],min);
        }
        int res = 0;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            max =Math.max(max,maxProduct[i]);
            min = Math.min(min,minProduct[i]);
        }
        return max - min;
    }
    public static int maxDifferenceInPair(int [] ar){  //arr[j] - arr[i] , is should be j>i, subtract first appearing element from later appear element
        if (ar.length<2) return ar[0];
        int res = ar[1] - ar[0];
        int min = Math.min(ar[0],ar[1]);
        for (int i=2;i<ar.length;i++){
            res = Math.max(res,ar[i] - min);
            min = Math.min(min,ar[i]);
        }
        return res;
    }
}
