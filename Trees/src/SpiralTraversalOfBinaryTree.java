import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SpiralTraversalOfBinaryTree {
    public static void main(String[] args) {
        Node root = Main.getTree();
        spiralTraversal(root);
        System.out.println();
        spiralTraverseUsingStacks(root);
    }
    public static void spiralTraversal(Node root){
        if (root == null ) return;
        Queue<Node> q = new LinkedList<>();
        boolean flag = true;
        q.add(root);

        while (!q.isEmpty()){
            int size = q.size();
            if (flag){
                for (int i = 0 ; i < size ; i++){
                    Node cur = q.poll();
                    System.out.print(cur.data+" ");
                    if (cur.left != null) q.add(cur.left);
                    if (cur.right != null) q.add(cur.right);
                }
                flag = false;
            }
            else {
                Stack<Node> stack = new Stack<>();
                for (int i = 0 ; i < size;i++){
                    Node cur = q.poll();
                    stack.push(cur);
                    if (cur.left != null) q.add(cur.left);
                    if (cur.right != null) q.add(cur.right);
                }
                while (!stack.isEmpty()){
                    System.out.print(stack.pop().data+" ");
                }
                flag = true;
            }
        }
    }
    public static void spiralTraverseUsingStacks(Node root){
        if (root == null) return;
        Stack <Node> st1 = new Stack<>();
        Stack <Node> st2 = new Stack<>();

        st1.push(root);
        while (! st1.isEmpty()){

            while (!st1.isEmpty()){
                Node cur = st1.pop();
                System.out.print(cur.data+" ");
                if (cur.left != null) st2.add(cur.left);
                if (cur.right != null) st2.add(cur.right);
            }
            while (!st2.isEmpty()){
                Node cur = st2.pop();
                System.out.print(cur.data+" ");
                if (cur.right != null) st1.add(cur.right);
                if (cur.left != null) st1.add(cur.left);
            }
        }
    }
}
