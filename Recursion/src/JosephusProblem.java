public class JosephusProblem {
    public static void main(String[] args) {
        System.out.println(josephus(4,2));
    }
    static int josephus(int n,int k){
        return jos(n,k)+1;
    }
    static int jos(int n,int k){
        if (n==1) return 0;
        return (jos(n-1,k)+k)%n;
    }
}
