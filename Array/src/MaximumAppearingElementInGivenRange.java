import java.util.Arrays;

public class MaximumAppearingElementInGivenRange {
    public static void main(String[] args) {
        int [] left = {1,8,5};
        int [] right = {5,11,7};
        System.out.println(maxAppearingIntegerInGivenRanges(left,right,left.length,13));
    }
    public static int maxAppearingIntegerInGivenRanges(int [] left, int [] right,int n,int max){
        int [] freq = new int[max];
        for (int i = 0;i<n;i++){
                freq[left[i]]++;
                freq[right[i]+1]--;
        }
        int res = 0;
        System.out.println(Arrays.toString(freq));
        for (int i=1;i<max;i++){
            freq[i] += freq[i-1];
            if (freq[i]>freq[i-1]){
                res = i;
                if (freq[i]==n) return res; // If all the elements distinct for every range
            }
        }
        System.out.println(Arrays.toString(freq));

        return res;
    }

}
