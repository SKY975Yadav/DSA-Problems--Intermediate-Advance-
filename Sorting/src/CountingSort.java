import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {

        int [] arr = {2,4,5,1,3,3,5,1,2};
        System.out.println(Arrays.toString(arr));
        countingSort(arr, arr.length,6);
        System.out.println(Arrays.toString(arr));

    }
    public static void countingSort(int [] arr,int n,int k){ // K is the range from 0 to max element in array TC and SC : O(n+k)
        int [] count = new int[k];
        for (int i = 0; i < n; i++) { // Frequencies of each element
            count[arr[i]]++;
        }

        for (int i = 1; i < k; i++) { // Cumulative Sum for each element i.e no.of elements less than or equals to cur element
            count [i] = count[i-1] + count[i];
        }

        int [] output = new int[n];
        for (int i = n-1; i >= 0 ; i--) {
            output[count[arr[i]]-1] = arr[i];
            count[arr[i]]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }

}
