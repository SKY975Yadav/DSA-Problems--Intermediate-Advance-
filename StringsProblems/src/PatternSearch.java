import java.util.Arrays;

public class PatternSearch {
    public static void main(String[] args) {
//        String txt = "sai krishna sai yadav sai";
//        String pattern = "sai";
        String text = "abxabcabcabyabcabyabcabcabyabcabcabyabcabcaby";
        String pattern = "abcabyabcabcaby";
        patternSearchNaive(text,pattern);
//        patternSearchImprovedNaiveApproach(text,pattern);
        patternSearchUsingRabinKorpAlgo(text,pattern);
        patternSearchUsingKMP(text,pattern);
    }


    // Method 1 TC : O(n*m)
    public static void patternSearchNaive(String text,String pattern){
        int n = text.length(),m = pattern.length();

        for (int i = 0; i <= n-m; i++) {
            int j = 0;
            while (j<m){
                if (pattern.charAt(j) != text.charAt(i+j))
                    break;
                j++;
            }
            if (j==m) System.out.print(i+" ");
        }
        System.out.println();
    }

    //Method 2 TC : O(n)  consider all characters are distinct in pattern naive solution
    public static void patternSearchImprovedNaiveApproach(String text,String pattern){ // Assumption on all characters in pattern are distinct

        int n = text.length(),m = pattern.length();
        for (int i = 0; i <= n-m;) {
            int j = 0;
            while (j<m){
                if (pattern.charAt(j) != text.charAt(i+j))
                    break;
                j++;
            }
            if (j==m) System.out.print(i+" ");
            if (j==0) i++;
            else i = i+j;
        }
        System.out.println();
    }



    // Method 3  TC : worst case : O(n*m) but on average O(n)
    static final int d=256;
    static final int q=101;
    public static void patternSearchUsingRabinKorpAlgo(String text, String pattern){
        int m = pattern.length(),n = text.length();
        int h = 1;
        for (int i = 0; i < m-1; i++) {  // pre compute the d power m-1
            h = (h*d) % q;
        }  // h = 88

        int p = 0, t= 0;
        for (int i = 0; i < m; i++) { // Pre compute the pattern hash value and the text hash value for the first loop
            p = ((p*d) + pattern.charAt(i)) % q;    // (0 + 115) % q = 14 --> (14*d + 96) % q = 44 --> (14*d^2 + 96*d + 105) % q = 57
            t = ((t*d) + text.charAt(i)) % q; // Same for this also
        }

        for (int i = 0; i <= n-m; i++) { // Search
            if (p==t){
                boolean flag = true;
                for (int j = 0; j < m; j++) {
                    if (text.charAt(i+j) != pattern.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) System.out.print(i+" "); // 0
            }
            if (i<n-m){
                t = (d * (t - text.charAt(i)*h) + text.charAt(i+m)) % q; // t = (256 * ( 57 - 115(88)) + 32) % 101 = -91
                if(t<0) t = t+q; // t = -91 + 101 = 10 follows
            }
        }
        System.out.println();
    }


    // Method 4 KMP most used algo : Knuth-Morris-Pratt

    // First build a LPS Table : Longest Proper Prefix which is also Suffix

    private static void lpsTable(String pattern,int [] lps){
        int len = 0,n = pattern.length();
        int i = 1;
        while(i<n){

            if (pattern.charAt(i)==pattern.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if (len == 0){
                    lps[i]=0;
                    i++;
                }
                else {
                    len = lps[len-1];
                }
            }
        }
    }
    public static void patternSearchUsingKMP(String text,String pattern){
        int n = text.length(),m = pattern.length();
        int [] lps = new int[m];
        lpsTable(pattern,lps);
        int i = 0,j = 0;
        while (i<n){

            if (text.charAt(i) == pattern.charAt(j)){
                i++;j++;
            }
            if (j==m){
                System.out.print(i-j+" ");
                j = lps[j-1];
            }
            else if (i < n && text.charAt(i) != pattern.charAt(j)){
                if (j==0) i++;
                else j = lps[j-1];
            }

        }
        System.out.println();
    }

}
