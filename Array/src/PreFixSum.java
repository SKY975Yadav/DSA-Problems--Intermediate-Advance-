import java.util.Arrays;

public class PreFixSum {
    public static void main(String[] args) {
        int[] arr ={2,3,5,4,6,1};
        System.out.println(Arrays.toString(arr));
        int n=arr.length;

        int[] ps =  new int[n];

        ps[0] = arr[0];

        for(int i=1; i<n; i++)
            ps[i] = ps[i-1]+ arr[i];
//        System.out.println(getSum(ps, 1, 3));

        int [] pws = new int[n];
        pws[0] = arr[0];
        for (int i=1;i<n;i++){
            pws[i] = (arr[i]*(i+1)) + pws[i-1];
        }
        System.out.println(Arrays.toString(ps));
        System.out.println(Arrays.toString(pws));

        System.out.println(getWeightedSum(ps,pws,1,2));
    }
    static int getSum(int [] ps,int l,int r){
        if (l==0) return ps[r];
        return ps[r]-ps[l-1];
    }
    static int getWeightedSum(int []ps,int[] pws,int l,int r){
        if (l==0) return pws[r];
        int weightSum = pws[r] - pws[l-1];
        int sum = ps[r]-ps[l-1];
        return weightSum - sum*l;
    }
}
