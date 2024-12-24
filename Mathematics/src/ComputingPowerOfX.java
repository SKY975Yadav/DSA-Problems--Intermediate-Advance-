public class ComputingPowerOfX {
    public static void main(String[] args) {
        System.out.println(powerOfX(10,5));
    }
//    static int powerOfX(int x,int n){ // recursive solution O(log n)
//        if (n==0) return 1;
//        int temp = powerOfX(x,n/2);
//        temp = temp*temp;
//        if (n%2==0) return temp;
//        else return temp*x;
//    }
    static int powerOfX(int x, int n) {
        int result = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                result *= x;
            }
            x *= x; // Square x
            n = n>>1; // Divide n by 2
        }
        return result;
    }

}
