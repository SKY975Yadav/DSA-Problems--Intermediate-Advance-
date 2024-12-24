public class TripletInSortedArray {
    public static void main(String[] args) {
        int [] arr = {2,4,6,11,24,34,35,45,67,70,79,89};
        System.out.println(isTripletInSortedArray(arr, arr.length,238));
    }
    public static boolean isTripletInSortedArray(int [] arr, int n,int x){
        for (int i = 0; i < n-2; i++) {
            if (PairWithGivenSumTwoPointersApproach.isPairWithGivenSum(arr,i+1,n-1,x -arr[i]))
                return true;
        }
        return false;
    }
}
