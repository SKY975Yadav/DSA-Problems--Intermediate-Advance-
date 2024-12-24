public class IsIsogram {
    public static void main(String[] args) {

        /*
        Given a string S of lowercase alphabets, check if it is isogram or not. An Isogram is a string in which no letter
         occurs more than once.
         */
        String st = "machine";
        System.out.println(isIsogram(st));
    }

    static boolean isIsogram(String data) {
        //Your code here
        boolean[] present = new boolean[26];

        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            if (present[ch - 'a']) return false;
            present[ch - 'a'] = true;
        }
        return true;
    }
}
