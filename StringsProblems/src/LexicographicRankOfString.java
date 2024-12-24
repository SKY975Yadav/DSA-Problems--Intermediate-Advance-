import java.util.HashMap;

public class LexicographicRankOfString {
    public static void main(String[] args) {
//        String str = "jfksdljavoxjdkndfedsfd";
//        System.out.println(lexicographicOfString(str));
//        System.out.println(fact(22));

        String st = "AASDFGHJKLLKJHGFDSAASDFGHJKLLKJHGFDSAASDFGHJKL";
        String st2 = "ASDFGHJKLLKJHGFDSAASDFGHJKLLKJHGFDSAASDFGHJKLASDF";
        System.out.println(isSubSequence(st,st2));

    }

    public static boolean isSubSequence(String A, String B)
    {
        //code here
        HashMap<Character,Integer> hmp1 = new HashMap<>();
        HashMap<Character,Integer> hmp2 = new HashMap<>();
        int n = B.length();

        for(char ch : B.toCharArray()){
            hmp1.put(ch,hmp1.getOrDefault(ch,0)+1);
        }

        for(char ch : A.toCharArray()){
            hmp2.put(ch,hmp2.getOrDefault(ch,0)+1);
        }
        for(char ch : A.toCharArray()){
            if(!hmp1.containsKey(ch)){
                return false;
            }
            if(hmp1.get(ch)<hmp2.get(ch)){
                return false;
            }
        }
        System.out.println(hmp1);
        System.out.println(hmp2);

        return true;
    }
    static final int CHAR = 256;
    public static int lexicographicOfString(String str){
        int res = 1;
        int n=str.length();
        int  mul=  fact(n);
        int[] count=new int[CHAR];
        for(int i=0;i<n;i++)
            count[str.charAt(i)]++;
        for(int i=1;i<CHAR;i++)
            count[i]+=count[i-1];
        for (int i = 0; i < n; i++) {
            mul = mul/(n-i);
            res += count[str.charAt(i) - 1]*mul;
            for (int j = str.charAt(i); j < 256; j++) {
                count[j]--;
            }
        }
        return res;
    }

    private static int fact(int n){
        if (n==1) return 1;
        return n*fact(n-1);
    }

}
