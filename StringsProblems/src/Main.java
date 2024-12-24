public class Main {
    public static void main(String[] args) {

    }
    public static void reverseString(char [] str,int i ,int j){
        while (i<=j){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
    }

}