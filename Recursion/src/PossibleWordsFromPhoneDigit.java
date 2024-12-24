import java.util.*;

public class PossibleWordsFromPhoneDigit {
    public static void main(String[] args) {
        System.out.println(possibleWords(new int[]{3, 4, 5},3));
    }
    static String [] keyPad = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static ArrayList <String> possibleWords(int a[], int N)
    {
        // your code here
        ArrayList<String > al = new ArrayList<>();
        String ans = "";
        possibleWordsTemp(al,a,ans);
        return al;
    }
    static void possibleWordsTemp(ArrayList<String > al,int []ar,String ans){
        if (ar.length==0) {
            al.add(ans);
            return;
        }
        String key = keyPad[ar[0]];
        for (int i=0;i<key.length();i++){
            possibleWordsTemp(al,Arrays.copyOfRange(ar,1,ar.length),ans + key.charAt(i));
        }
    }

}
