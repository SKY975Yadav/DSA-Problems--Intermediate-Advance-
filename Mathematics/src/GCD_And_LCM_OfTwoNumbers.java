import java.util.ArrayList;

public class GCD_And_LCM_OfTwoNumbers {
    public static void main(String[] args) {
        System.out.println(GCDOfTwoNumbersUsingIterative(2,4));
        System.out.println(LCMOfTwoNumbers(2,8));
    }
    //Naive Solution
//    static int GCDOfTwoNumbers(int a,int b){
//        int min = Math.min(a,b);
//        for (int i = min;i>0;i--){
//            if (a%i==0 && b%i==0)
//                return i;
//        }
//        return -1;
//    }
    static int GCDOfTwoNumbers(int a , int b){
        if(b==0) return a;
        return GCDOfTwoNumbers(b,a%b);
    }
    static int GCDOfTwoNumbersUsingIterative(int a,int b){
        while (b!=0){
            int temp = a;
            a = b;
            b = temp%b;
        }
        return a;
    }
    static int LCMOfTwoNumbers(int a, int b){
        return (a*b)/GCDOfTwoNumbersUsingIterative(a,b);
    }
}
