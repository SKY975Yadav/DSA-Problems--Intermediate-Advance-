public class FindPeakElement {
    public static void main(String[] args) {
        int [] arr = {1,2,3};
        System.out.println(findPeakElement(arr,arr.length));
    }
    public static int findPeakElement(int [] arr, int n){ // Peak element which is greater or equals to it neighbours or adjacents
        int low = 0, high = n-1;
        while (low<=high){
            int mid = (low+high)/2;
            if ((mid==0 || arr[mid]>=arr[mid-1]) && (mid == n-1 || arr[mid]>=arr[mid+1])) return arr[mid];
            if (mid>0 && arr[mid-1]>=arr[mid])
                high = mid-1;
            else low = mid+1;
        }
        return -1;
    }
}
