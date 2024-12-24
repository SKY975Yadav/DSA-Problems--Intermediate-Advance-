public class Print_Nto1_and_1toN {
    public static void main(String[] args) {
//        nTo1(5);
        oneToN(5);
    }
    private static void nTo1(int n){
        if (n<=0){
            return ;
        }
        System.out.println(n);
        nTo1(n-1);
    }
    private static void oneToN(int n){
        if (n<=0) return; //Base Case
        oneToN(n-1); //Recursive Call
        System.out.println(n);
    }
}
