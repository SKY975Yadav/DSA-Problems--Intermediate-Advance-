public class FirstOccurrenceOFElement {
    public static void main(String[] args) {
        int [] arr = {-23,1,1,1,2,3,5,8,10,10,10,101,106,106};
        System.out.println(recFirstOccurrenceOFElement(arr,0,arr.length-1,10));
        System.out.println(iterFirstOccurrenceOFElement(arr,arr.length,10));
    }

    //Recursive TC: O(log n) and SC : O(log n)
    public static int recFirstOccurrenceOFElement(int [] arr,int l,int r,int k){
        if (l>r) return -1;

        int mid = (l+r)/2;
        if (arr[mid]<k){
            return recFirstOccurrenceOFElement(arr,mid+1,r,k);
        }
        else {
            if (arr[mid]==k && ( mid == 0 || arr[mid-1]!=k)) return mid;
            return recFirstOccurrenceOFElement(arr, l, mid - 1, k);
        }

    }

    //iterative TC: O(log n) and SC : O(1)
    public static int iterFirstOccurrenceOFElement(int [] arr,int n,int k){
        if (arr[0]==k) return 0;
        int l = 0;
        int r= n-1;
        while (l<=r){
            int mid = (l+r)/2;
            if (arr[mid]<k){
                l = mid+1;
            }
            else {
                if (arr[mid]==k && arr[mid-1]!=k) return mid;
                r = mid-1;
            }
        }
        return -1;
    }
}
