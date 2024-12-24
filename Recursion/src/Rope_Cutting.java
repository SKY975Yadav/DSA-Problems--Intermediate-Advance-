public class Rope_Cutting {
    public static void main(String[] args) {
//        System.out.println(ropeCutting(23,12,9,11));
//        System.out.println(ropeCutting(18,1,9,11));
        System.out.println(ropeCutting(18,3,4,7));
    }

    private static int ropeCutting(int num ,int a, int b ,int c){
        if (num==0) return 0;
        if (num<0) return -1;
        int res = max(ropeCutting(num-a,a,b,c),ropeCutting(num-b,a,b,c),ropeCutting(num-c, a,b,c));
        if (res == -1){
            return -1;
        }
        return res+1;

    }
    private static int max(int a, int b, int c){
        if (a>=b && a>=c) return a;
        if (b>=a && b>=c) return b;
        return c;
    }
}
