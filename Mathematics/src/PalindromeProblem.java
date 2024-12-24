public class PalindromeProblem {
    public static void main(String[] args) {
        System.out.println(checkPalindrome(1044014));
    }
//    static boolean checkPalindrome(int num){ // Naive Solution TC : O(log10(n)) + O(n) + O(n) where n = digits, simplify O(n), ASC : O(n) + O(1) + (n) = O(n), n= digits
//        StringBuilder st = new StringBuilder(String.valueOf(num));
//        st.reverse();
//        return st.toString().compareTo(String.valueOf(num))==0;
//    }
    static boolean checkPalindrome(int num){ // TC : O(n) , n = digits, SC : O(1)
        int res = 0;
        int temp = num;
        while(temp != 0){
            res = res*10 + (temp%10);
            temp = temp/10;
        }
        return res == num;
    }
}
