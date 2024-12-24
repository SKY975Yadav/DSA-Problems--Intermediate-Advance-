import java.util.Arrays;

public class LeftMostNonRepeatingElement {
    public static void main(String[] args) {
        String st = "asfjhffsdakwersnn";
        int ind = leftMostNonRepeatingElement(st);
        System.out.println(st.charAt(ind));

    }

    public static int leftMostNonRepeatingElement(String st){
        int [] fi = new int[256];
        Arrays.fill(fi,-1);
        for (int i = 0;i<st.length();i++){
            if (fi[st.charAt(i)]==-1)
                fi[st.charAt(i)] = i;
            else fi[st.charAt(i)] = -2;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 256; i++) {
            if (fi[i] >= 0){
                res = Math.min(res,fi[i]);
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}
