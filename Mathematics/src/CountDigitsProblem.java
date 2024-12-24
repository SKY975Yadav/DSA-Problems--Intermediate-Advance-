import java.math.BigInteger;

public class CountDigitsProblem {
    public static void main(String[] args) {
//        System.out.println(countDigits(3012));
        System.out.println(countDigitsInFactorial(5));
        System.out.println(Math.log10(4));
    }
//    static int countDigits(int num){//using iterative ,TC: O(digits), ASC : O(1)
//        int res = 0;
//        while(num > 0){
//            num = num/10;
//            res++;
//        }
//        return res;
//    }
    static int countDigits(int num){ //Using Recursion , TC: O(digits), ASC : O(digits)
        if (num<10) return 1;
        return 1 + countDigits(num/10);
    }
    public static int countDigitsInFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1; // Factorials of 0 and 1 have 1 digit
        }
        double digits = 0;
        for (int i = 2; i <= n; i++) {
            digits += Math.log10(i);
            System.out.println(i+" "+digits);
        }
        // Add 1 to account for the integer part of the logarithm
        return (int) Math.floor(digits) + 1;
    }
}
/*
5 = 120 = 3 digits
8 =  40,320 = 5 digits
10 = 3628800 = 7 digits
14 = 87,178,291,200 = 11
15 = 1307674368000 = 13 digits

20 = 2432902008176640000 = 19 digits



 */