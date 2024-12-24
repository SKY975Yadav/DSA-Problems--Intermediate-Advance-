public class IsPalidrome {
    public static void main(String[] args) {
        String st = "aaabbbaaa";
        System.out.println(isPalidrome(st));
    }
    public static boolean isPalidrome(String st){
        int i = 0, j = st.length()-1;

        while (i<j){
            if (st.charAt(i) != st.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean isPalindrome(String st) {
        int i = 0, j = st.length()-1;

        while (i<j){

            if (!((st.charAt(i)>=97 && st.charAt(i)<=122) || (st.charAt(i)>=48 && st.charAt(i) <= 57))){
                i++;
                continue;
            }
            if (!((st.charAt(j)>=97 && st.charAt(j)<=122) || (st.charAt(j)>=48 && st.charAt(j) <= 57))){
                j--;
                continue;
            }
            if (st.charAt(i) != st.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
