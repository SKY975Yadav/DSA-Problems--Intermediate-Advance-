import java.util.ArrayList;
import java.util.List;

public class FixBSTWithTwoNodesSwapped {
    public static void main(String[] args) {

    }
    public static void fixBST(Node root){
        List<Node> al = new ArrayList<>();
        inorderTraversal(root,al);
        Node prev = new Node(Integer.MIN_VALUE);
        Node first = null,second = null;
        for (Node cur : al) {
            if (cur.data < prev.data) {
                if (first == null) {
                    first = prev;
                }
                second = cur;
            }
            prev = cur;
        }
        if (first != null) {
            int temp = first.data;
            first.data = second.data;
            second.data = temp;
            
        }
    }
    public static void inorderTraversal(Node root, List<Node> list){
        if (root == null) return;
        inorderTraversal(root.left,list);
        list.add(root);
        inorderTraversal(root.right,list);
    }

    static class Utility{
        Node prev,first,second;
    }

    public static void fixBstMeth2(Node root){
        helperFun(root,new Utility());
    }
    private static void helperFun(Node root,Utility ut){
        if (root == null) return;
        helperFun(root.left,ut);
        if (ut.prev != null && root.data < ut.prev.data){
            if (ut.first == null) ut.first = ut.prev;
            ut.second = root;
        }
        ut.prev = root;
        helperFun(root.right,ut);
    }
}
