import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class AllPrimeNumbersLesserThanOrEqualsToN {
    public static void main(String[] args) {
//        primeNumbersLessOrEqualsToN(90);
//        System.out.println(multiplicationUnderModulo(9223372036854775807L,9223372036854775807L));
//        BigDecimal bg = new BigDecimal(10);
//        System.out.println(bg.pow(120));
        int k = (int )Math.sqrt(24);
        System.out.println(k);
    }
    public static long sumUnderModulo(long a, long b) {
        // code here
        long bg = a+b;
        System.out.println(bg);
        long mod = (long) (Math.pow(10, 9) + 7);
        System.out.println(mod);
        return bg % mod;
    }
    static long multiplicationUnderModulo(long a, long b)
    {
        // add your code here
        long modulo = 1000000007;

        // Initialize the result variable
        long result = 0;

        // Perform modular multiplication
        while (b > 0) {
            if (b % 2 == 1) {
                result = (result + a) % modulo;
            }
            a = (2 * a) % modulo;
            b /= 2;
        }

        return result;
    }
    static void primeNumbersLessOrEqualsToN(int n){

        boolean [] isPrime = new boolean[n+1];
        Arrays.fill(isPrime,true);
        for (int i=2;i<=n;i++){
            if (isPrime[i]){
                System.out.print(i+" ");
                for (int j=i*i;j<=n;j=j+i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}

