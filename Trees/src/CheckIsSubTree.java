import java.util.LinkedList;
import java.util.Queue;

public class CheckIsSubTree {
    public static void main(String[] args) {
        Node root = Main.getTree();
        root.left.left.left = new Node(90);
        BinaryTreeTraversal.inOrderTraversal(root);
        Node temp = new Node(70);
        temp.left = new Node(80);
        temp.right = new Node(34);
        temp.left.left = new Node(90);
        System.out.println();
        BinaryTreeTraversal.inOrderTraversal(temp);
        System.out.println();

        System.out.println(isSubtree(root,temp));
    }
    public static boolean isSubtree(Node T, Node S) {
        // add code here.
        if(T == null) return false;

        if(isIdentical(T,S)) return true;

        return isSubtree(T.left,S) || isSubtree(T.right,S);

    }

    private static boolean isIdentical(Node root1, Node root2)
    {
        // Code Here
        if(root1==null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        return (root1.data == root2.data) && isIdentical(root1.left,root2.left) && isIdentical(root1.right,root2.right);
    }
}
