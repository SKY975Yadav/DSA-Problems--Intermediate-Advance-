
public class Largest_Element_In_Array {
    public static void main(String[] args) {
        int [] arr = {4,6745,1343,1532,15435};
        System.out.println(IndexOfLargestElementInArray(arr,arr.length,1346));
//        System.out.println(LargestElementInArray(arr));

    }
    private static int IndexOfLargestElementInArray(int[] arr,int n,int x){
        int ans=Integer.MAX_VALUE;
        int temp=0;
        int ar [] = new int[n];
        for(int i=0;i<n;i++){
            if(arr[i]>x){
                ar[temp]=arr[i];
                temp++;
            }
        }
        for (int j:ar){
            System.out.print(j+" ");
        }
        System.out.println();
        for(int i=0;i<n;i++){
            if (ar[i]<ans && ar[i]!=0){
                ans=ar[i];
            }
        }
        return ans;
//        int k=0;
//        for (int i=1;i<arr.length;i++){
//            if (arr[i]>arr[k]){
//                k=i;
//            }
//        }
//        return k;
    }
    private static int LargestElementInArray(int[] arr){
        int num = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > num) {
                num = j;
            }
        }
        return num;
    }
    // Sum of array
    // Solution 1 : O(n/2)
    private static int sum(int []a,int first,int last){
//        if (a.length==0)return 0;
        if(first==last)return a[first];
        if (first>last) return 0;
        return a[first]+a[last]+sum(a,first+1,last-1);
    }
    // Solution 2 : O(n/4)
    private static int sumOfArray(int []a,int first,int last,int mid1,int mid2){
        if (first==mid1){
            if (mid2==last) return a[first]+a[last];
            return a[first]+a[mid2]+a[last];
        }
        else if(mid1<first && mid2==last) {
            return a[mid2];
        }
        if (last==mid2) return a[last];
        if (last<mid2) return 0;
        return a[first]+a[mid1]+a[mid2]+a[last]+sumOfArray(a,first+1,last-1,mid1-1,mid2+1);
    }

}
