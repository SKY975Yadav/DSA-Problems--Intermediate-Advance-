import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpace {
    public static void main(String[] args) {
        long [] arr1 = {1,5,7,9,10};
        long [] arr2 = {2,3,6,7,7,11,15};
        merge(arr1,arr2, arr1.length, arr2.length);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

    }
    public static void merge(long[] arr1, long[] arr2, int n, int m)
    {
        // code here

        int len = n+m;
        int gap = (len/2) + (len%2);


        while(gap > 0 ){

            int left = 0, right = left + gap;

            while(right < len){

                if(left < n && right >= n){ // if left in arr1 and right in arr2
                    swapArrayElements(arr1,arr2,left,right - n);
                }
                else if(left >= n){ // if both in right
                    swapArrayElements(arr2,arr2,left-n,right - n);
                }
                else{ //if both in left
                    swapArrayElements(arr1,arr1,left,right);
                }
                left++;
                right++;
            }
            if(gap == 1) return;
            gap = (gap/2) + (gap % 2);
        }
    }

    private static void swapArrayElements(long [] arr1, long [] arr2, int ind1,int ind2){

        if(arr1[ind1] > arr2[ind2]){ //swapping elements
            long temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2 ] = temp;
        }

    }
}
