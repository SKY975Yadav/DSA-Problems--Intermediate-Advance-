import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class MaximumOccuredIntegerInRanges {
    public static void main(String[] args) {
        int [] L = {2,1,3};
        int [] R = { 5,3,9};
        System.out.println(maxOccured(L,R,3,9));
    }
    public static int maxOccured(int L[], int R[], int n, int max){
        HashMap<Integer,Integer> hmp = new HashMap<>(max);
        int maxCount = 0;
        int res = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j = L[i];j<=R[i];j++){
                int count = hmp.getOrDefault(j,0)+1;
                hmp.put(j, count);
                if(count>maxCount || (count==maxCount && j<res)){
                    maxCount = count;
                    res = j;
                }
            }
        }
        return res;
    }
}
