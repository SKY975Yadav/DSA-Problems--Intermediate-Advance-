public class AnagramSearch {
    public static void main(String[] args) {

        String st  = "geeksforgeeks";
        String pat = "froxs";
        System.out.println(isAnagramInText(st,pat));
    }

    private static final int CHAR =256;
    public static boolean isAnagramInText(String text,String pattern){
        int n = text.length(),m = pattern.length();
        int [] CT = new int[CHAR];
        int [] CP = new int[CHAR];

        for (int i = 0; i < m; i++) {
            CT[text.charAt(i)]++;
            CP[pattern.charAt(i)]++;
        }

        for (int i = m; i < n; i++) {
            if(isSame(CT,CP)){
                return true;
            }
            CT[text.charAt(i)]++;
            CT[text.charAt(i - m)]--;
        }
        return false;
    }
    private static boolean isSame(int [] arr1, int [] arr2){
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]){
                 return false;
            }
        }
        return true;
    }
}
