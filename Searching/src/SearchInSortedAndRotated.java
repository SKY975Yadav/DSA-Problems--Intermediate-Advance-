public class SearchInSortedAndRotated {
    public static void main(String[] args) {
//        int [] arr = {21,24,27,34,100,125,246,300,1,5,8,9};
//        System.out.println(searchInSortedAndRotated(arr,arr.length,300));
//        System.out.println(searchInSortedAndRotatedEffSol(arr,arr.length,300));

        int [] arr = {100,120, 1,4,7,8,9,10,11,12,34,56};
        System.out.println(minNumber(arr,0,arr.length-1));
    }
    public static int searchInSortedAndRotated(int [] arr, int n,int x){ // TC : O( point + log(x))
        int temp = arr[0];
        if (temp==x) return 0;
        int i = 1;
        for ( ;i<n;i++) {
            if (arr[i] < arr[i - 1])
                break;
        }
        int low,high;
        if (temp > x){
            low = i;
            high = n-1;
        }else {
            low = 0;
            high = i-1;
        }
//        return BinarySearch.binarySearchForSubArray(arr,low,high,x);// you can use this instead of below code
        while (low<=high){
            int mid = (low+high)/2;
            if (arr[mid] == x) return mid;
            if (arr[mid]<x){
                low = mid+1;
            }
            else high = mid-1;
        }
        return -1;
    }

    public static int searchInSortedAndRotatedEffSol(int [] arr, int n,int x){ // Efficient solution TC : O(log x)
        int low = 0,high = n-1;
        while (low<=high){
            int mid = (low+ high)/2;
            if (arr[mid] == x) return mid;
            if (arr[low]<arr[mid]){
                if (arr[low]>=x && x < arr[mid])
                    high = mid-1;
                else low = mid+1;
            }
            else {
                if (x>arr[mid] && x <= arr[high] )
                    low = mid+1;
                else high = mid-1;
            }
        }
        return -1;
    }

    static int minNumber(int arr[], int low, int high) // minimum in sorted and rotated . I.e nothing but the first element before rotated
    {
        // Your code here
        int res = arr[0];
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]<arr[0]){
                res = arr[mid];
                high = mid -1;
            }
            else {
                low = mid +1;
            }
        }
        return res;
    }
}
