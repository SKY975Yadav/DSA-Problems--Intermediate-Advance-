import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {
    public static void main(String[] args) {
        int [] arr = {123,12,51,34,599,124};
        System.out.println(Arrays.toString(arr));
        bucketSort(arr, arr.length,6);
        System.out.println(Arrays.toString(arr));

    }
    public static void bucketSort(int [] arr , int n, int k){
        // This sorting algo useful for when we have uniform distribution in array
        // That is elements are in a range are uniformly distributed
        // Ex : we have elements in the array from 300 to 500 , then it should be  that no.of elements are close / equals for every group
        // ex we consider 20 elements in each group then we have 10 groups , then all the 10 group should have equal elements, it's not happen that one group contain 10 elements and other 0 elements. It should distribute uniformly

        int maxVal = arr[0];
        for (int x : arr){
            maxVal = Math.max(maxVal,x);
        }
        maxVal++;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            al.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            al.get((k * arr[i])/maxVal).add(arr[i]);
        }

        for (ArrayList<Integer> temp : al){
            Collections.sort(temp);
        }
        int ind = 0;
        for (ArrayList<Integer> integers : al) {
            for (Integer integer : integers) {
                arr[ind++] = integer;
            }
        }
    }

}
