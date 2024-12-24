public class SearchInInfiniteSizedArray {
    public static void main(String[] args) {
        int [] arr = {1,3,5,10,15,25,35,78,90,123,1234,12345,123456};
        System.out.println(searchAnElementInInfiniteSizedArray(arr,10));
    }
    public static int searchAnElementInInfiniteSizedArray(int [] arr, int x ){ //unbounded binary search
        if (arr[0]==x) return 0;
        int low ,high =1;
        while (arr[high]<x){
            high = high*2;
        }
        if (arr[high]==x) return high;
        low = high/2+1;
        high = high-1;
        while (low<=high){
            int mid = (low+high)/2;
            if (arr[mid]==x) return mid;
            else if (arr[mid]<x) {
                low = mid+1;
            }
            else high = mid-1;
        }

        return -1;
    }
}
