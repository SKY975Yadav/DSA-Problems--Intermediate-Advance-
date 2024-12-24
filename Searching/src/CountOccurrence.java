public class CountOccurrence {
    public static void main(String[] args) {
        int [] arr = {1,2,2,2,5,8};
        System.out.println(countOccurrenceOfElement(arr,arr.length,1));
        System.out.println(countOccurrenceOfElementSol2(arr,arr.length,1));
    }
    //Time complexity = O(log n + count) . SC : O(1)
    public static int countOccurrenceOfElement(int [] arr,int n,int k){
        int l = 0,r=n-1;
        while (l<=r){
            int mid = (l+r)/2;
            if (arr[mid]<k){
                l = mid+1;
            }
            else if(arr[mid]>k){
                r = mid-1;
            }
            else {
                int res = 1;
                int rightSide = mid+1;
                while (rightSide<n && arr[rightSide]==k){
                    rightSide++;
                    res++;
                }
                int leftSide = mid-1;
                while (leftSide>=0 && arr[leftSide]==k){
                    leftSide--;
                    res++;
                }
                return res;
            }
        }
        return -1;
    }

    //Efficient solution TC : O(log n) SC : O(1)
    public static int countOccurrenceOfElementSol2(int [] arr, int n,int k){
        int first = FirstOccurrenceOFElement.iterFirstOccurrenceOFElement(arr,n,k);
        if (first==-1) return 0;
        return (LastOccurrenceOFElement.iterLastOccurrenceOFElement(arr,n,k) - first + 1);
    }
}