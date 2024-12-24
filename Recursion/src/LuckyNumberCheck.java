public class LuckyNumberCheck {
    public static void main(String[] args) {
        System.out.println(isLucky(17,2));
        System.out.println(isLucky(17));
    }
    public static boolean isLucky(int N) {
        int count = 2;
        int i = 1;
        while (count <= N) {
            if (N % count == 0) {
                return false;
            }
            N -= N / count;
            count++;
        }
        return true;
    }
    public static boolean isLucky(int n,int counter){
        if (counter>n) return true;
        if (n % counter == 0) return false;
        return isLucky(n-(n/counter),counter+1);
    }
}
