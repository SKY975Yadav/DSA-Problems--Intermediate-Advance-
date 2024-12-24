public class TrappingRainWater {
    public static void main(String[] args) {
        int [] ar = {5,0,6,2,3};
        System.out.println(trappingRainWater(ar,ar.length));
    }
    public static int trappingRainWater(int [] ar,int n){
        int [] lMax = new int[n];
        int [] rMax = new int[n];
        lMax[0] = ar[0];
        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(ar[i],lMax[i-1]);
        }
        rMax[n-1] = ar[n-1];
        for (int i = n-2; i >=0; i--) {
            rMax[i] = Math.max(ar[i],rMax[i+1]);
        }
        int res = 0;
        for (int i = 1; i < n-1; i++) {
            res += Math.min(lMax[i],rMax[i]) - ar[i];
        }
        return res;
    }
}
