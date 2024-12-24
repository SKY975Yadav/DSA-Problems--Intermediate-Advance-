public class AllPermutationsOfAString {
    public static void main(String[] args) {
        allPermutationsOfAString("ABCD",0);
    }
    static void allPermutationsOfAString(String str,int i){
        if (i==str.length()-1) System.out.print(str+" ");
        for (int j = i;j<str.length();j++){
            str = swap(str,i,j);
            allPermutationsOfAString(str,i+1);
            str = swap(str,i,j);
        }
    }
    static String swap(String a,int i,int j){
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
