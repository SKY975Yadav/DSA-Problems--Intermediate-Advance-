import java.util.TreeSet;

public class CeilingOnLeftSideInArray {
    public static void main(String[] args) {
        int [] arr = {12,5,10,23,52,13,34};
        ceilingOnLeft(arr);
    }
    private static void ceilingOnLeft(int [] arr){
        TreeSet<Integer> ts = new TreeSet<>();
        System.out.print(-1+" ");
        for (int x : arr){
            if (!ts.isEmpty()){
                if (ts.ceiling(x) != null) {
                    System.out.print(ts.ceiling(x)+ " ");
                }else System.out.print(-1+" ");
            }
            ts.add(x);
        }
    }
}
