import java.util.Arrays;

public class ElementsThatAreSmallerThanCurrentElementOnRightSide {

    static class Pair{
        int data,ind;
        Pair(int data,int ind){
            this.data = data;
            this.ind = ind;
        }

        @Override
        public String toString() {
            return this.data+" "+ this.ind;
        }
    }
    public static void main(String[] args) {
        int [] arr = {12, 1, 2, 3, 0, 11, 4};
        int [] temp = constructLowerArray(arr, arr.length);
        System.out.println(Arrays.toString(temp));
    }
    static int[] constructLowerArray(int[] arr, int n) {
        // code here
        Pair [] pairs = new Pair[n];
        int [] res = new int[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(arr[i],i);
        }

        mergeSort(pairs,0,n-1,res);

        return res;
    }

    static void mergeSort(Pair [] pairs,int l,int r,int [] res){ // Sorting array in descending order

        if(l<r){
            int mid = (l+r)/2;
            mergeSort(pairs,l,mid,res);
            mergeSort(pairs,mid+1,r,res);
            merge(pairs,l,mid,r,res);
        }
    }

    static void merge(Pair [] pairs , int l, int mid , int r,int [] res){

        Pair [] temp = new Pair[r-l+1];
        int i = l;
        int j = mid+1;
        int k = 0;

        while(i <= mid && j <= r){

            if (pairs[i].data <= pairs[j].data){
                temp[k++] = pairs[j++];
            }
            else{
                res[pairs[i].ind] += r - j +1;
                temp[k++] = pairs[i++];
            }
        }

        while ( i <= mid){
            temp[k++] = pairs[i++];
        }

        while ( j <= r){
            temp[k++] = pairs[j++];
        }

        for (int m = l; m <= r; m++) {
            pairs[m] = temp[m-l];
        }
    }
}
