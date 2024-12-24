public class Subset {
    public static void main(String[] args) {
        subSet("ABC","",0);
    }
    private static void subSet(String s,String cur,int i){
        if (i==s.length()){
            System.out.println(cur);
            return;
        }
        subSet(s,cur,i+1);
        subSet(s,cur.concat(String.valueOf(s.charAt(i))),i+1);
    }
}
