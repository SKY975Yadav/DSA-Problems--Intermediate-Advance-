public class CountingInversion {
    public static void main(String[] args) {
        int [] arr = {2,13,6,1,4,7,8};
        int res = countInversion(arr,0, arr.length-1);
        System.out.println(res);
    }
    /*
   Problem 7 :
       This video discusses the problem of taking an unsorted array and counting the inversions in it. There are two conditions for the  elements to be inverse:
       arr[i] > arr[j]
       i < j

       simply no.of element that true for above condition
    */
    public static int countInversion(int [] arr,int l,int r){ //TC : O(n log n)
        int res = 0;
        if(l<r){
            int mid = (l+r)/2;
            res += countInversion(arr,l,mid);
            res += countInversion(arr,mid+1,r);
            res += countInvAndMerge(arr,l,mid,r);
        }
        return res;
    }
    private static int countInvAndMerge(int [] arr, int l,int m,int r){
        int n1 = m - l + 1,n2 = r - m;
        int [] left = new int[n1];
        int [] right = new int[n2];
        System.arraycopy(arr, l , left, 0, n1);
        System.arraycopy(arr, m+1 , right, 0, n2);
        int res = 0,i=0,j=0,k=l;
        while (i<n1 && j<n2){
            if (left[i]<=right[j]){
                arr[k++] = left[i++];
            }
            else {
                arr[k++] = right[j++];
                res += n1-i;
            }
        }
        while(i<n1)
            arr[k++]=left[i++];
        while(j<n2)
            arr[k++]=right[j++];
        return res;
    }
}
