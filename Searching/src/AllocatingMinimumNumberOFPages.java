import java.util.HashMap;

public class AllocatingMinimumNumberOFPages {
    public static void main(String[] args) {
        int [] arr = {13,18,10,15,20};
        System.out.println(allocatingMinNumberOfPages(arr, arr.length,4));
    }
    /*
    You have N books, each with A[i] number of pages. M students need to be allocated contiguous books, with each student getting at least one book.
    Out of all the permutations, the goal is to find the permutation where the sum of maximum number of pages in a book allotted to a student should be minimum, out of all possible permutations.
    Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).
     */
    public static int allocatingMinNumberOfPages(int [] arr,int n,int k){
        if (k>n) return -1;
        int sum = 0,max = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            max = Math.max(max,arr[i]);
        }
        int low = max, high = sum, res = -1;
        while(low<=high){
            System.out.println(low +" "+high);
            int mid = (low+high)/2;
            System.out.println(mid);
            if(isFeasible(arr,n,k,mid)){
                System.out.println(true);
                res = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return res;
    }
    public static boolean isFeasible(int [] arr,int n,int k,int ans){
        int sum = 0,students = 1;
        for (int i = 0; i < n; i++) {
            if (sum + arr[i] > ans){
                students++;
                sum = arr[i];
            }else sum += arr[i];
        }
        return (students<=k);
    }

}
