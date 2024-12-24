import java.util.HashMap;

public class IsAnagram {
    public static void main(String[] args) {
//        String st1 = "listejn";
//        String st2 = "siljent";
//        System.out.println(isAnagram(st1,st2));
        String pattern = "abba", s = "dog cat cat dog";
        System.out.println(wordPattern(pattern,s));
    }
    public static boolean isAnagram(String st1,String st2){
        if (st1.length() != st2.length()) return false;
        int [] count = new int[256];
        for (int i = 0 ; i < st1.length();i++){
            count[st1.charAt(i)]++;
            count[st2.charAt(i)]--;
        }
        for (int i = 0;i<256;i++){
            if (count[i] != 0) return false;
        }
        return true;
    }
    public boolean wordPattern(String pattern, String s) {
        String [] arr = s.split(" ");
        if(arr.length != pattern.length()) return false;
        HashMap<String,Character> map = new HashMap<>();
        for(int i = 0 ; i < arr.length;i++){
            char ch = pattern.charAt(i);
            if(map.containsKey(arr[i]) && map.get(arr[i]) != ch){
                return false;
            }
            map.put(arr[i],ch);
        }
        return true;
    }
}
