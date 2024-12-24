public class IsPanagram {
    public static void main(String[] args) {
/*
You are given a string s. You need to find if the string is a panagram or not.
A panagram contains all the letters of english alphabet at least once.
 */
    }
    public static boolean isPanagram(String str)
    {
        // Check if given string is panagram
        if(str.length()<26) return false;
        char x ;
        boolean [] visited = new boolean[26];
        for(int i=0;i<str.length();i++){
            x = str.charAt(i);
            if(x>='a' && x<='z'){
                visited[x - 'a'] = true;
            }
            if(x>='A' && x<= 'Z'){
                visited[x - 'A'] = true;
            }
        }
        for(boolean y : visited){
            if(y==false) return false;
        }
        return true;
    }
}
