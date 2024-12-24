
/*
    Example1 : print fun print
    Example2 : fun print pun
    Example3 : Log n
    Example4 : Binary digits of a number
    Example5 : Sum of N
    Example6 : Palindrome Check
    Example7 : Sum of digits
    Example8 : Power of n
 */
public class PracticeRecursionProblem {
    public static void main(String[] args) {
//        example1(5);
//        example2(5);
//        System.out.println(example3(16));
//        example4(5);
//        System.out.println(example5(5));
//        System.out.println(example6("aykya",0,4));
//        System.out.println(example7(123456));
//        System.out.println(example8(2,30));
    }
    private static void example1(int n){
        if (n==0) return ;
        System.out.println(n);
        example1(n-1);
        System.out.println(n);
    }
    private static void example2(int n){
        if (n==0) return ;
        example2(n-1);
        System.out.println(n);
        example2(n-1);
    }
    private static int example3(int n){//example for log n
        if (n==1) return 0;
        return 1+ example3(n/2);
    }
    private static void example4(int n){//example for Binary digits of a number
        if (n==0) return ;
        example4(n/2);
        System.out.print(n%2+" ");
    }
    private static int example5(int n){//Sum of N
        if (n==1) return 1;
        return n+example5(n-1);
    }
    private static boolean example6(String str,int start,int end){//Palindrome Check
        if (start>=end){
            return true;
        }
        return (str.charAt(start)==str.charAt(end)) && example6(str,start+1,end-1);
    }
    private static int example7(int n){
        if (n==0) return 0;
        return example7(n/10)+n%10;
    }
    private static long example8(int n,int p){
        if (n==0) return 0;
        if (p==0) return 1;
        if (p==1 ) return n;
        return n*example8(n,p-1);

    }
}
