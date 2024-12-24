import java.util.HashMap;
import java.util.Map;

public class MedianInTwoSortedArrays {
    public static void main(String[] args) {
//        int [] arr1 = {2,3,8,21,24,26,29,31,42};
//        int [] arr2 = {11,14,23,25,29,33,38,56,89,98,100};
        int [] arr1 = {3};
        int [] arr2 = {5};
        System.out.println(medianInTwoSortedArrays(arr1,arr2, arr1.length, arr2.length));
        HashMap<Integer,Integer> hmp = new HashMap<>();
    }
    public static double medianInTwoSortedArrays(int [] arr1,int [] arr2,int n1,int n2){
        if (n1>n2){
            int [] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
            int tempSize = n1;
            n1 = n2;
            n2 = tempSize;
        }
        int low = 0,high = n1;
        while (low<=high){
            int mid1 = (low+high)/2;
            int mid2 = ((n1+n2+1)/2) - mid1;
            int minInRight1 = (mid1==n1)? Integer.MAX_VALUE:arr1[mid1]; //3 , Infinite
            int maxInLeft1 = (mid1==0)?Integer.MIN_VALUE:arr1[mid1-1]; //- Infinite , 3

            int minInRight2 =(mid2==n2)? Integer.MAX_VALUE:arr2[mid2]; // + Infinite, 3
            int maxInLeft2 = (mid2==0)?Integer.MIN_VALUE:arr2[mid2-1]; // 5, - Infinite

            if (maxInLeft1<=minInRight2 && maxInLeft2<=minInRight1){
                if ((n1+n2)%2==0){
                    return (double)  (Math.max(maxInLeft1,maxInLeft2) + Math.min(minInRight1,minInRight2))/2;
                }
                else return Math.max(maxInLeft1,maxInLeft2);
            }
            if (maxInLeft1 > minInRight2)
                high = mid1-1;
            else low = mid1+1;
        }
        return -1;
    }
    public int countOccurence(int[] arr, int n, int k)
    {
        // your code here,return the answer
        HashMap<Integer,Integer> hmp = new HashMap<>();
        for(int x : arr){
            hmp.put(x,hmp.getOrDefault(x,0)+1);
        }
        int count = 0;
        for(Map.Entry<Integer,Integer> mp : hmp.entrySet()){
            if(mp.getValue()>(n/k)){
                count++;
            }
        }
        return count;
    }

}
