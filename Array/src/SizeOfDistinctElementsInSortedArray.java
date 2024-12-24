import java.util.Arrays;

public class SizeOfDistinctElementsInSortedArray {
    public static void main(String[] args) {
        int [] arr = {23,23,232,232,4523,4734,4734,9772};
        System.out.println(sizeOfDistinctElementsInSortedArray(arr));
        System.out.println(Arrays.toString(arr));
    }
    private static int sizeOfDistinctElementsInSortedArray(int [] arr){
        int res=1;
        for (int i=1;i<arr.length;i++){
            if (arr[res-1]!=arr[i]){
                arr[res]=arr[i];
                res++;
            }
        }
        return res;
    }
}

