import java.util.Arrays;
import java.util.HashMap;

public class SearchTechnique {
    public static void main(String[] args) {
//        System.out.println(linearSearch(3,new int[]{34,33,6,23,3,5}));
//        System.out.println(binarySearchUsingLoop(new int[]{13,16,26,31,43,55},55));
//        System.out.println(binarySearchUsingRecursion(new int[]{13,16,26,31,43,55},0,5,55));

    }
    private static int linearSearch(int key,int []ar){
        for (int i=0;i<ar.length;i++){
            if (ar[i]==key){
                return i;
            }
        }
        return -1;
    }
    private static int binarySearchUsingLoop(int []ar,int key){
        int low=0;
        int high = ar.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if (ar[mid]==key)
                return mid;
            else if (ar[mid]>key)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
    private static int binarySearchUsingRecursion(int []ar,int low,int high,int key){
        if (low>high) return -1;
        int mid = (low+high)/2;
        if (ar[mid]==key) return mid;
        else if (ar[mid]>key) return binarySearchUsingRecursion(ar,low,mid-1,key);
        else return binarySearchUsingRecursion(ar,mid+1,high,key);
    }
}
