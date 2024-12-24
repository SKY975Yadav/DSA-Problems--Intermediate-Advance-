import javax.swing.*;

public class AllDivisorsOfN {
    public static void main(String[] args) {
        printAllDivisorsOfN(100);
    }
//    static void printAllDivisorsOfN(int n){ //not in order
//        for (int i =1;i*i<=n;i++){
//            if (n % i ==0){
//                System.out.print(i+" ");
//                if (i != n/i){
//                    System.out.print((n/i)+" ");
//                }
//            }
//        }
//    }
    // for in order traverse two times
    static void printAllDivisorsOfN(int n){
        int i;
        for (i = 1;i*i<=n;i++){
            if (n%i==0) System.out.print(i + " ");
        }
        while (i>1) {
            i--;
            if ( i!=n/i && n%i==0) System.out.print((n / i) + " ");
        }
    }
    static public int exactly3Divisors(int n)
    {
        //Your code here
        int count = 0;
        for(int i=2;i*i<=n;i++){
            if(isPrime(i)){
                count++;
            }
        }
        return count;

    }
    public static boolean isPrime(int n) {
        // code here
        if(n==1) return false;
        else if(n==2 || n==3) return true;
        else if(n%2 == 0 || n%3 == 0) return false;
        for(int i = 5 ; i*i<=n;i=i+6){
            if(n%i==0 || n%(i+2) ==0){
                return false;
            }
        }
        return true;
    }
}
