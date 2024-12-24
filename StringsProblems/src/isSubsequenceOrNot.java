public class isSubsequenceOrNot {
    public static void main(String[] args) {
        String st1 = "geeksforgeeks";
        String st2 = "gfg";
        System.out.println(isSubSequence(st1,st2));
    }
    public static boolean isSubSequence(String st1,String st2){
        int j = 0,m = st2.length(),n = st1.length();
        for (int i = 0;i<n && j<m;i++){
            if (st1.charAt(i)==st2.charAt(j)){
                j++;
            }
        }
        return m == j;
    }
}
