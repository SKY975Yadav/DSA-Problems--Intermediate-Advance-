import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class VerticalSumOfBinaryTree {
    public static void main(String[] args) {
        Node root = Main.getTree();
        root.left.left.right = new Node(30);
        System.out.println(verticalSumOfBT(root));
    }
    public static List<Integer> verticalSumOfBT(Node root){
        TreeMap<Integer,Integer> tmp = new TreeMap<>();
        recMethod(root,0,tmp);
        return tmp.values().stream().toList();
    }
    private static void recMethod(Node root,int hd,TreeMap<Integer,Integer> tmp){
        if (root == null) return;
        recMethod(root.left,hd-1,tmp);
        tmp.put(hd,tmp.getOrDefault(hd,0)+root.data);
        recMethod(root.right,hd+1,tmp);
    }
}
