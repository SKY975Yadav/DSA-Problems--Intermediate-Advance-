
import java.util.ArrayList;

class Solution{
    static ArrayList<String> al = new ArrayList<>();
    static int i = 0;
    public static ArrayList<String> permute(String str){
        //code here
        if (i == str.length()-1)
            al.add(str);
        else
        {
            for (int j = i; j <= str.length()-1; j++)
            {
                str = swap(str,i,j);
                i = i+1;
                permute(str);
                str = swap(str,i,j);
            }
        }
        return al;
    }
    static String swap(String a, int i, int j)
    {
        char temp;
        System.out.println(i+" "+ j);
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
public class Main {
    public static void main(String[] args) {
        loop(2);
    }
    static  int i = 0;
    static void loop(int n){
        System.out.println("i= "+ ++i + " n = "+n);
        if (n==1) return;
        loop(n/2);
    }
//    static long power(int num,int r)
//    {
//        long n= num;
//        long res = 1;
//        int mod = 1000000007;
//        while(r>0){
//            if(r%2==1)
//                res = (res * n) % mod;
//            n = (n* n) % mod;
//            r = r/2;
//        }
//        return res;
//    }
    static long power(int x, int n)
    {
        if(n == 0)
            return 1;
        long temp = power(x, n/2);
        temp = (temp * temp)%1000000007;
        if(n % 2 == 0)
            return temp;
        else
            return (temp * x)%1000000007;
    }
    static int digitalRoot(int n){
        int sum = 10;
        while (sum>9){
            sum = recursiveNature(n);
            n= sum;
        }
        return sum;
    }
    static int recursiveNature(int n){
        if(n<10)return n;
        return n%10 + recursiveNature(n/10);
    }
}