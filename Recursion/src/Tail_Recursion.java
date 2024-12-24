public class Tail_Recursion {
    public static void main(String[] args) {
//        nTo1(5);
//        oneToN(5,1);
        System.out.println(factorial(5,1));
    }
    private static void nTo1(int n){
        //label start :
        if (n<=0){
            return ;
        }
        System.out.println(n);
        nTo1(n-1);//This fun is internally converted to n=n-1  and goto start
    }
    private static void oneToN(int n,int k){
        //Label start :
        if (n==0) return;
        System.out.println(k);
        oneToN(n-1,k+1);// it is internally converted into n=n-1 and k= k+1 and goto start
    }
    private static int factorial(int n,int k){
        //label start :
        if (n==0||n==1) return k;
        return factorial(n-1,k*n);//internal implementation k=k*n and n= n-1 and goto start
    }
}
