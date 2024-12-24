import java.util.ArrayList;

public class AllSubStringsOfAString {
    public static void main(String[] args) {
        System.out.println(allSubStringsOfString("str"));
    }
    public static ArrayList<String> allSubStringsOfString(String str){ // O(n*n)
        ArrayList<String> res = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                res.add(str.substring(i,j+1));
            }
        }
        return res;
    }

}
