import java.util.HashSet;

public class PairWithGivenSum {
    public static void main(String[] args) {
        Node root = Main.getTree();
        System.out.println(isPariWithSum(root,100));

    }
    public static boolean isPariWithSum(Node root,int sum){
        return recFun(root,sum,new HashSet<>());
    }
    public static boolean recFun(Node root, int sum, HashSet<Integer> hs){
        if (root == null) return false;
        if (recFun(root.left,sum,hs)) return true;
        if (hs.contains(sum - root.data)){
            return true;
        }hs.add(root.data);
        return recFun(root.right,sum,hs);
    }
}
