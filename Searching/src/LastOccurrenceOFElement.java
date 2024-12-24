public class LastOccurrenceOFElement {
    public static void main(String[] args) {
        int [] arr = {-1,1,1,1,2,3,5,8,10,10,10,101,106,108};
        System.out.println(recForLastOccurrenceOFElement(arr,0,arr.length-1,106));
        System.out.println(iterLastOccurrenceOFElement(arr,arr.length,106));

    }

    public static int recForLastOccurrenceOFElement(int [] arr,int l,int r,int k){
        if (l>r) return -1;

        int mid = (l+r)/2;
        if (arr[mid]<=k){
            if (arr[mid]==k &&( mid == arr.length-1 || arr[mid+1]!=k)) return mid;
            return recForLastOccurrenceOFElement(arr,mid+1,r,k);
        }
        else {
            return recForLastOccurrenceOFElement(arr, l, mid - 1, k);
        }

    }

    //iterative TC: O(log n) and SC : O(1)
    public static int iterLastOccurrenceOFElement(int [] arr,int n,int k){
        if (arr[n-1]==k) return n-1;
        int l = 0;
        int r= n-1;
        while (l<=r){
            int mid = (l+r)/2;
            if (arr[mid]<=k){
                if (arr[mid]==k && arr[mid+1]!=k) return mid;
                l = mid+1;
            }
            else {
                r = mid-1;
            }
        }
        return -1;
    }
}
