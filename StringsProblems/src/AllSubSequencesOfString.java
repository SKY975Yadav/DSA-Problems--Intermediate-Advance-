import java.util.ArrayList;

public class AllSubSequencesOfString {
    public static void main(String[] args) {
        System.out.println(allSubSequencesOfString("str"));
    }
    public static ArrayList<String> allSubSequencesOfString(String str){  // O(2^n)
        ArrayList<String> res = new ArrayList<>();
        subSequences(str,"",0,res);
        return res;
    }
    public static void subSequences(String str,String cur,int ind,ArrayList<String> res){
        if (ind == str.length()){
            res.add(cur);
            return;
        }
        subSequences(str,cur+str.charAt(ind),ind+1,res);
        subSequences(str,cur,ind+1,res);
    }
}
