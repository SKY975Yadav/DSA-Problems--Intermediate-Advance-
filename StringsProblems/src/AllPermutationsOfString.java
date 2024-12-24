import java.util.ArrayList;

public class AllPermutationsOfString {
    public static void main(String[] args) {

    }
    public static ArrayList<String> allPermutesOfString(String str){  // O(n×n!)  sc :  O(n×n!)
        ArrayList<String> res = new ArrayList<>();
        permute(str,0,res);
        return res;
    }
    private static void permute(String str, int i,ArrayList<String> res){

        if (i == str.length()-1){
            res.add(str);
            return;
        }

        for (int j = i; j <  str.length(); j++) {
            swap(str,i,j);
            permute(str,i+1,res);
            swap(str,i,j);
        }
    }

    static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
