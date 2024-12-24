import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Pair{
    int start , end,len;
    Pair(int s,int e){
        start = s;
        end = e;
        len = 0;
    }
}
public class SmallestWindowInAStringThatContainsAllCharsOfAnotherGivenString { // TC O(s) and SC : O(s + p) or O(1)
    public static void main(String[] args) {
        String s = "timetopractice";
        String p = "toct";
        System.out.println(smallestWindow(s,p));
        System.out.println(smallestWindowUsingHashMap(s,p));
        System.out.println(smallestWindowMoreEfficient(s,p));
    }
    private static boolean check(int [] s,int []p){
        for (int i = 0; i < 256; i++) {
            if (p[i]>s[i]){
                return false;
            }
        }
        return true;
    }
    private static boolean checkMap(HashMap<Character,Integer> map1,HashMap<Character,Integer>map2){
        for (Map.Entry<Character,Integer> map : map2.entrySet()){
            char key = map.getKey();
            int freq = map.getValue();
            if (!map1.containsKey(key)) return false;
            if (map1.get(key)<freq) return false;
        }
        return true;
    }
    public static String smallestWindow(String s,String p){
        if (p.length()>s.length()) return "-1";
        char [] st = s.toCharArray(),pt = p.toCharArray();

        int [] countS = new int[256],countP = new int[256];

        for (int i = 0; i < p.length(); i++) {
            countP[pt[i]]++;
        }

        String ans = "";
        int start = 0 , end = 0;

        while (start <= end && end < s.length()){
            countS[st[end]]++;

            while (start <= end && countS[st[start]] >= countP[st[start]]){

                String temp = s.substring(start,end+1);
                if (check(countS,countP) && (temp.length()<ans.length() || ans.isEmpty()) ){
                    ans = temp;
                }
                if (countS[st[start]] == countP[st[start]]) break;
                countS[st[start]]--;
                start++;
            }
            end++;
        }
        return ans.isEmpty()?"-1":ans;
    }

    public static String smallestWindowUsingHashMap(String s, String p)
    {
        // Your code here

        if (p.length() > s.length()) return "-1";

        char[] st = s.toCharArray();
        char[] pt = p.toCharArray();

        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countP = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            countP.put(pt[i], countP.getOrDefault(pt[i], 0) + 1);
        }


        int start = 0, end = 0;
        Pair pair = new Pair(0,0);
        while (start <= end && end < s.length()) {
            countS.put(st[end], countS.getOrDefault(st[end], 0) + 1);

            while (start <= end && isCountSValid(countS, countP)) {

                int diff = end - start + 1;

                if (diff < pair.len || pair.len == 0) {
                    pair.start = start;
                    pair.end = end+1;
                    pair.len = pair.end - pair.start;
                }

                countS.put(st[start], countS.get(st[start]) - 1);
                if (countS.get(st[start]) == 0) {
                    countS.remove(st[start]);
                }
                start++;
            }
            end++;
        }
        String ans = s.substring(pair.start,pair.end);
        return ans.isEmpty() ? "-1" : ans;
    }
    private static boolean isCountSValid(HashMap<Character, Integer> countS, HashMap<Character, Integer> countP) {
        for (char key : countP.keySet()) {
            if (countS.getOrDefault(key, 0) < countP.get(key)) {
                return false;
            }
        }
        return true;
    }
    public static String smallestWindowMoreEfficient(String s, String p)
    {
        // Your code here

        if (p.length() > s.length()) return "-1";

        char[] st = s.toCharArray();
        char[] pt = p.toCharArray();

        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countP = new HashMap<>();

        for (char c : pt) {
            countP.put(c, countP.getOrDefault(c, 0) + 1);
        }

        int start = 0, end = 0, matches = 0;
        Pair pair = new Pair(0, 0);

        while (end < s.length()) {
            char endChar = st[end];
            countS.put(endChar, countS.getOrDefault(endChar, 0) + 1);

            if (countP.containsKey(endChar) && countS.get(endChar).intValue() == countP.get(endChar).intValue()) {
                matches++;
            }

            while (matches == countP.size()) {
                int diff = end - start + 1;

                if (diff < pair.len || pair.len == 0) {
                    pair.start = start;
                    pair.end = end + 1;
                    pair.len = diff;
                }

                char startChar = st[start];
                countS.put(startChar, countS.get(startChar) - 1);
                if (countP.containsKey(startChar) && countS.get(startChar).intValue() < countP.get(startChar).intValue()) {
                    matches--;
                }
                start++;
            }
            end++;
        }

        String ans = s.substring(pair.start, pair.end);
        return ans.isEmpty() ? "-1" : ans;
    }
}
