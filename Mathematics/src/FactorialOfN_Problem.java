import java.math.BigDecimal;
import java.util.Objects;

public class FactorialOfN_Problem {
    public static void main(String[] args) {
//        System.out.println(factorialOfN(2000));
        System.out.println(Math.log10(11));
//        System.out.println(trailingZerosInFactorial(65));
    }
//    static long factorialOfN(int n){//Using Recursive   for return type int 0<n<17 and for long : 0<n<21, TC : O(n) , SC : O(n)
//        if (n==1) return 1;
//        return n* factorialOfN(n-1);
//    }
//    static BigDecimal factorialOfN(int n){ //  recursion For range 0<n<11490 , for big number it will through stack overflow runtime error, TC : O(n) , SC : O(n)
//        if (n==1) return new BigDecimal(1);
//        return new BigDecimal(n).multiply(factorialOfN(n-1));
//    }

//    static int factorialOfN(int n){ //TC : O(n) , SC : O(1)
//        int res = 1;
//        for (int i =2;i<=n;i++){
//            res = res*i;
//        }
//        return res;
//    }
    static BigDecimal factorialOfN(int n){ //TC : O(n) , SC : O(1), For up to Integer.MAX_VALUE, iterative
        BigDecimal res = new BigDecimal(1);
        for (int i =2;i<=n;i++){
            res = res.multiply(new BigDecimal(i));
        }
        return res;
    }
    //Special problem trailing zeros in factorial
    static int trailingZerosInFactorial(int num){
        int res= 0;
        for (int i=5;i<=num;i=i*5){
            res += num/i;
        }
        return res;
    }
    static int digitsInFactorial(int n){
        // code here
        if (n == 0 || n == 1) {
            return 1; // Factorials of 0 and 1 have 1 digit
        }

        double digits = 0;
        for (int i = 2; i <= n; i++) {
            digits += Math.log10(i);
        }

        // Add 1 to account for the integer part of the logarithm
        return (int) Math.floor(digits) + 1;
    }


}
