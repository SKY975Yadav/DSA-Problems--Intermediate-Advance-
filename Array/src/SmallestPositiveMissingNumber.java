public class SmallestPositiveMissingNumber {
    public static void main(String[] args) {
        int [] ar = {-3,2,-1,4,-4,1,5};
        System.out.println(smallestPositiveMissingNum(ar,ar.length));
    }
    public static int smallestPositiveMissingNum(int [] arr,int n){ //Given an array we have to find out smallest missing number  It start with 1
        for (int i=0;i<n;i++){
            if (arr[i]<0) arr[i] = 0;
        }
        for (int i=0;i<n;i++){
            int temp = Math.abs(arr[i]);
            if (temp>=1 && temp <=n){
                if (arr[temp-1]>0) arr[temp-1] *= -1 ;
                if (arr[temp-1]==0) arr[temp-1] = -1* (n+1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i]>=0){
                return i+1;
            }
        }
        return n+1;
    }
}
