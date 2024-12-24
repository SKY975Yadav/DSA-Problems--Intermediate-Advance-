public class BinarySearch {
    public static void main(String[] args) {
        int [] arr = {1,2,3,10,23,26,36,47,48,78,79,88,100};
        System.out.println(binarySearch(arr, arr.length,48));
        System.out.println(binarySearchRecursive(arr,0, arr.length-1, 48));
        System.out.println(binarySearchForSubArray(arr,0,arr.length-1,100));
    }
    public static int binarySearch(int [] arr, int n, int x){
        int low = 0,high = n-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) return mid;
            if (arr[mid] < x) {
                low = mid + 1;
            } else high = mid - 1;
        }
        return -1;
    }
    public static int binarySearchRecursive(int [] arr,int low,int high,int x){

        int mid = (low + high)/2;
        if (arr[mid] == x) return mid;
        if (arr[mid]<x) {
            return binarySearchRecursive(arr,mid+1,high,x);
        }
        else return binarySearchRecursive(arr,low,mid-1,x);
    }
    public static int binarySearchForSubArray(int [] arr, int low,int high, int x){
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) return mid;
            if (arr[mid] < x) {
                low = mid + 1;
            } else high = mid - 1;
        }
        return -1;
    }
}
