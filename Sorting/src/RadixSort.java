import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int [] arr = {12,315,1083,2341,134,1351,8234};
        System.out.println(Arrays.toString(arr));
        radixSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));

    }
    public static void radixSort(int [] arr,int n){
        //We usd counting sort algo for each digit from array elements and apply counting sort on each digits
        //Ex : 123 , 415 , 8, 12, 34,456
        // first we apply counting sort on last digits of each element i.e : 3, 5,8,2,4,6
        // then last second  , then last third . if some element doesn't have digits we consider it as 0 so it will come first
        // In this way we sort the array
        // TC : O(d * (n+b)) , d is digits and n is no.of elements and b is base
        // If we take base big then digits operations decrease and vcvars
        int max = Integer.MIN_VALUE;
        for (int x :arr){
            max = Math.max(max,x);
        }
        for (int exp = 1; max/exp > 0; exp =exp * 10) {
            countingSort(arr,n,exp);
        }
    }
    public static void countingSort(int []arr,int n,int exp){

        int [] count = new int[10];

        for (int i = 0; i < n; i++) { // take regular digits from each element and for each digits for all elements we apply counting sort
            count[(arr[i]/exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] = count[i-1] + count[i];
        }
        int [] output = new int[n];
        for (int i = n-1; i >= 0; i--) {
            output[count[(arr[i]/exp) % 10]-1] = arr[i];
            count[(arr[i]/exp)%10]--;
        }
        System.arraycopy(output,0,arr,0,n);
    }
}
