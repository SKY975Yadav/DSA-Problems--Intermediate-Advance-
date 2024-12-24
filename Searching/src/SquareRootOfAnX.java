public class SquareRootOfAnX {
    public static void main(String[] args) {
        System.out.println(sqrtOfX(1));
    }
    public static int sqrtOfX(int x){
        if (x==1 || x==0) return x;
        int low = 1, high = x/2,ans = -1;
        while (low<=high){
            int mid = (high+low)/2;
            int sqr = mid * mid;
            if (sqr == x){
                return mid;
            }
            if (sqr > x){
                high = mid-1;
            }
            else {
                low = mid+1;
                ans = mid;
            }
        }
        return ans;
    }
}
