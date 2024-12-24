public class MaximumLengthOfEvenOdd {
    public static void main(String[] args) {
        int [] ar ={1,2,3,4,5,6,7,8,9,10};
        System.out.println(maxLenOfEvenOdd(ar));
    }
    public static int maxLenOfEvenOdd(int [] arr){
        //Let assume true means even false mean odd
        int n = arr.length;
        if (n==0) return -1;
        int maxLen = 1;
        int curLen = 1;
        for (int i = 1; i < n; i++) {
            if ((arr[i]%2==0 && arr[i-1]%2!=0) || (arr[i]%2!=0 && arr[i-1]%2==0))
                curLen++;
            else {
                maxLen = Math.max(curLen,maxLen);
                curLen = 1;
            }
        }
        return Math.max(maxLen,curLen);
    }
}
