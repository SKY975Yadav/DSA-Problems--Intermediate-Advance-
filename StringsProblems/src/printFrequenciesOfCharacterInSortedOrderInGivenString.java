public class printFrequenciesOfCharacterInSortedOrderInGivenString {
    public static void main(String[] args) {
        String st = "geeksforgeeks";
        printFreq(st);
    }
    public static void printFreq(String st){
        int [] count = new int[26];
        for (int i = 0; i < st.length(); i++) {
            count[st.charAt(i)-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i]>0){
                System.out.print((char) (i+'a'));
                System.out.println(" "+ count[i]);
            }
        }
    }
}
