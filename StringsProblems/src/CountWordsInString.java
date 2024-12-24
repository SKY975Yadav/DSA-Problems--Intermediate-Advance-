public class CountWordsInString {
    public static void main(String[] args) {
        String st = "sai krishna yadav";
        System.out.println(countWords(st));
    }
    public static int countWords(String str)
    {
        // find and return the number of words
        // present in the string
        int count = 0;
        for(int i = 0 ; i< str.length();i++){
            if(str.charAt(i)==' '){
                count++;
            }
        }
        return count+1;
    }
}
