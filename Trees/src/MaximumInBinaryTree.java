import java.util.LinkedList;
import java.util.Queue;

public class MaximumInBinaryTree {
    public static void main(String[] args) {
        Node root = Main.getTree();
        System.out.println(maximumInBinaryTreeUsingBFS(root));
        System.out.println(maximumInBinaryTreeUsingDFS(root));
    }
    public static int maximumInBinaryTreeUsingDFS(Node root){// TC : O(N) SC : O(height)
        if (root==null)return Integer.MIN_VALUE;
        return Math.max(root.data,Math.max(maximumInBinaryTreeUsingDFS(root.left),maximumInBinaryTreeUsingDFS(root.right)));
    }
    public static int maximumInBinaryTreeUsingBFS(Node root){// TC : O(N) SC : O(Max width)
        if (root==null) return-1;
        int max = root.data;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node cur = q.poll();
            int left = Integer.MIN_VALUE,right = Integer.MIN_VALUE;
            if (cur.left!=null){
                left = cur.left.data;
                q.add(cur.left);
            }
            if (cur.right!=null){
                right = cur.right.data;
                q.add(cur.right);
            }
            max = Math.max(max,Math.max(left,right));
        }
        return max;
    }
}
