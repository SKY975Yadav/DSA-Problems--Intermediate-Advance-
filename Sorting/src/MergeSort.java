import java.util.*;

class MergeSortProblems{
    //Problem 1 merge two sorted arrays and return an array: TC : Theta(N) , SC : Theta(1)
    public int[] mergeTwoSortedArrays(int [] ar1,int [] ar2){
        int i=0,j=0,k=0;
        int m = ar1.length;
        int n= ar2.length;
        int [] temp = new int[m+n];
        while (i<m && j<n) {
            if (ar1[i] <= ar2[j]) {
                temp[k] = ar1[i];
                i++;
                k++;
            } else{
                temp[k] = ar2[j];
                j++;
                k++;
            }
        }
        while (i<m) {temp[k] = ar1[i];i++;k++;}
        while (j<n) {temp[k] = ar2[j];j++;k++;}

        return temp;
    }
    //Problem 2 given an array,and 3 values  of low,mid,high where the one part of arrays was sorted from low to mid and
    //another part is sorted from mid+1 to high.Note that low is not always zero it can be anything i.e may be from the middle of the array
    //we need to sort total array. Idea is simple store one part of array in one array store another part in another array
    //TC : Theta(N) , SC : Theta(1)
    public int[] mergeOfTwoParts(int []ar,int low,int mid,int high){
        int n1 =mid-low+1;
        int n2 = high-mid;
        int [] left = new int[n1];
        int [] right = new int[n2];
        System.arraycopy(ar, low, left, 0, n1);
        for (int i=0;i<n2;i++){
            right[i]=ar[mid+i+1];
        }
        int i=0,j=0,k=low;
        while (i<n1 && j<n2) {
            if (left[i] <= right[j]) {
                ar[k] = left[i];
                i++;
                k++;
            } else{
                ar[k] = right[j];
                j++;
                k++;
            }
        }
        while (i<n1) {ar[k] = left[i];i++;k++;}
        while (j<n2) {ar[k] = right[j];j++;k++;}
        return ar;
    }
}
public class MergeSort {
    static int[] constructLowerArray(int[] arr, int n) {
        int[] res = new int[n];
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int a : arr){
            treeMap.put(a, treeMap.getOrDefault(a, 0) + 1);
        }
        for (int a : arr){
            SortedMap<Integer,Integer> sm = treeMap.headMap(a);
        }
        return res;
    }
    public static void main(String[] args) {
        //Implementing mergeSort
        int []exm = {3,25,6,5,23,12,9,23,12};
//        int [] as = constructLowerArray(exm,exm.length);
//        System.out.println(Arrays.toString(as));

//        System.out.println("Before Sorting : ");
//        for (int num : exm) System.out.print(num+" ");
//        System.out.println();
//        implementingMergeSort(exm,0,exm.length-1);
//        System.out.println("After Sorting : ");
//        for (int num : exm) System.out.print(num+" ");
//        System.out.println();
//        MergeSortProblems msp = new MergeSortProblems();
        //Problem 1 :
//        int [] ar1 = {12,45,65,89,564};
//        int [] ar2 = {34,35,62,62,89,102,106,452};
//        int [] res = msp.mergeTwoSortedArrays(ar1,ar2);
        //Problem 2
//        int [] temp = new int[]{13,26,17,3,14,23,16,19,25};
//        int [] res = msp.mergeOfTwoParts(temp,3,5,8);
//        for (int num : res) System.out.print(num+" ");


        // K most Frequent element
//        int [] ar = {4,4,4,4,4};
//        System.out.println(kMostFrequent(ar,ar.length,1));
    }
    public static void implementingMergeSort(int[]ar,int l,int r){ //l=5 r =10
        if (r>l){
            int mid = l+(r-l)/2;
            implementingMergeSort(ar,l,mid);
            implementingMergeSort(ar,mid+1,r);
            merge(ar,l,mid,r);
        }
    }
    public static void merge(int []ar,int low,int mid,int high){
        int n1 =mid-low+1;
        int n2 = high-mid;
        int [] left = new int[n1];
        int [] right = new int[n2];
        System.arraycopy(ar, low, left, 0, n1);
        for (int i=0;i<n2;i++){
            right[i]=ar[mid+i+1];
        }
        int i=0,j=0,k=low;
        while (i<n1 && j<n2) {
            if (left[i] <= right[j]) {
                ar[k] = left[i];
                i++;
                k++;
            } else{
                ar[k] = right[j];
                j++;
                k++;
            }
        }
        while (i<n1) {ar[k] = left[i];i++;k++;}
        while (j<n2) {ar[k] = right[j];j++;k++;}
    }


    static int kMostFrequent(int arr[], int n, int k){
        // your code here
        int sum = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int x : arr){
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        ArrayList<ArrayList<Integer>> al =  new ArrayList<>();
        for(int i=0;i<=n;i++){
            al.add(new ArrayList<>());
        }
        al.add(new ArrayList<>());
        for(Map.Entry<Integer,Integer> map : hm.entrySet()){
            al.get(map.getValue()).add(map.getKey());
        }
        int count = 0;
        for(int i = n ; i>=0;i--){
            for(int x : al.get(i)){
                if(count == k) return sum;
                count++;
                sum += i;
            }
            if(count == k) return sum;
        }
        return -1;
    }

}
