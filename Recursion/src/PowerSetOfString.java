import java.util.ArrayList;

public class PowerSetOfString {
    public static void main(String[] args) {
        System.out.println(powerSet("abc"));
    }
    static ArrayList<String> powerSet(String s)
    {
        // add your code here
        ArrayList<String> al = new ArrayList<>();
        StringBuilder st = new StringBuilder(s);
        temp(al,st,new StringBuilder(""),0);
        return al;
    }
    static void temp(ArrayList<String> al, StringBuilder s,StringBuilder tem, int n){
        if(n==s.length()) {
            al.add(tem.toString());
            return;
        }
        temp(al,s,tem,n+1);
        temp(al,s,tem.append(s.charAt(n)),n+1);
        tem.deleteCharAt(tem.length() - 1);
    }
}
