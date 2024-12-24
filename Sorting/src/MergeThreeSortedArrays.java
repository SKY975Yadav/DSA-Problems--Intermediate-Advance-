import java.util.ArrayList;

public class MergeThreeSortedArrays {
    public static void main(String[] args) {
        int [] arr1  = {1,5,6,10,14,25,26};
        int [] arr2 = {0,4,6,7,11,14};
        int [] arr3 = {2,3,7,11,25,26};
        System.out.println(merge3sorted(arr1,arr2,arr3));
    }
    public static ArrayList<Integer> merge3sorted(int[] A, int[] B, int[] C)
    {
        // add your code here
        ArrayList<Integer> res = new ArrayList<>();

        int n1 = A.length, n2 = B.length, n3 = C.length;
        int i = 0 , j = 0 , k = 0 ;
        while(i < n1 && j < n2 && k < n3){

            if(A[i] <= B[j] && A[i] <= C[k]){
                res.add(A[i]);
                i++;
            }
            else if(B[j] <= A[i] && B[j] <= C[k]){
                res.add(B[j]);
                j++;
            }

            else{
                res.add(C[k]);
                k++;
            }
        }

        if(i == n1){
            mergeTwoSortedArrays(B,C,n2,n3,j,k,res);
        }
        else if(j == n2){
            mergeTwoSortedArrays(A,C,n1,n3,i,k,res);
        }
        else if(k == n3) {
            mergeTwoSortedArrays(A,B,n1,n2,i,j,res);
        }

        return res;

    }

    private static void mergeTwoSortedArrays(int [] arr1, int [] arr2,int n1, int n2, int i , int j ,ArrayList<Integer> res) {

        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                res.add(arr1[i]);
                i++;
            } else {
                res.add(arr2[j]);
                j++;
            }
        }
        while (i < n1) {
            res.add(arr1[i++]);
        }
        while (j < n2) {
            res.add(arr2[j++]);
        }
    }
}
