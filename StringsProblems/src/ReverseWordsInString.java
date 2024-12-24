import java.util.Arrays;
import java.util.Stack;

public class ReverseWordsInString {
    public static void main(String[] args) {
        String st = "sai krishna yadav";
        char [] temp = st.toCharArray();

        System.out.println(st);
//        reverseWords(temp,temp.length);
//        System.out.println(temp);
    }
    static void reverseWords(char str[],int n){
        int start=0;
        for(int end=0;end<n;end++){
            if(str[end]==' '){
                Main.reverseString(str,start,end-1);
                start=end+1;
            }
        }
        Main.reverseString(str,start,n-1);
        Main.reverseString(str,0,n-1);

    }
    String reverseWords(String s)
    {
        // code here
        int n = s.length();
        Stack<String> st = new Stack<>();
        int i,start = 0;
        for(i=0;i<n;i++){
            if(s.charAt(i)=='.'){
                st.add(s.substring(start,i));
                start = i+1;
            }
        }
        st.add(s.substring(start,n));

        StringBuilder sb = new StringBuilder("");
        while(!st.isEmpty()){
            String temp = st.pop();
            sb.append(temp);
            sb.append(".");
        }
        sb.delete(sb.length()-1,sb.length());
        return sb.toString();
    }
    public static long findSum(String str)
    {
        // your code here
        Long temp = Long.valueOf(str);
        int n = str.length();
        long sum= 0;
        while (n>0){
            sum += n%10;
            n = n/10;
        }
        return sum;
    }
}
