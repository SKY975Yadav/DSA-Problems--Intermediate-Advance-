import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
    public static void main(String[] args) {
        Node root = Main.getTree();
        System.out.println(maxWidthOfBinaryTree(root));
        root.left.left = null;
        System.out.println(maxWidthOfBinaryTree(root));
    }
    public static int maxWidthOfBinaryTree(Node root){
        if (root == null ) return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int res = 0;
        while (!q.isEmpty()){
            int size = q.size();
            res = Math.max(res,size);
            for (int i = 0 ; i < size ; i++){
                Node cur = q.poll();
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add((cur.right));
            }
        }
        return res;
    }
}
