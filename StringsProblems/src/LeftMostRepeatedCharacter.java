public class LeftMostRepeatedCharacter {
    public static void main(String[] args) {
        String st =  "saikrihn";
        System.out.println(st.charAt(leftMostRepeatedCharacter(st)));
    }
    public static int leftMostRepeatedCharacter(String st){
        boolean [] visited = new boolean[256];
        int res = -1;
        for (int i = st.length()-1;i>=0;i--){
            if (visited[st.charAt(i)]){
                res = i;
            }else
                visited[st.charAt(i)] = true;
        }
        return res;
    }
}
