import java.util.LinkedList;
import java.util.*;
import java.util.Queue;

public class PrintViewOfBinaryTree {
    public static void main(String[] args) {
        Node root = Main.getTree();
        System.out.println("Left View Of Binary Tree");
        leftViewOfBinaryTree(root);
        System.out.println();
        leftViewOfBinaryTreeRec(root);
        System.out.println("\n");

        System.out.println("Right View Of Binary Tree");
        rightViewOfBinaryTree(root);
        System.out.println();
        rightViewOfBinaryTreeRec(root);

    }


    //Iterative Solutions :
    public static void leftViewOfBinaryTree(Node root){
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int curSize = q.size();
            for (int i = 0; i < curSize; i++) {
                Node cur = q.poll();
                if (i==0) {
                    System.out.print(cur.data + " ");
                }
                if (cur.left!=null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
        }
    }
    public static void rightViewOfBinaryTree(Node root){
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int curSize = q.size();
            for (int i = 0; i < curSize; i++) {
                Node cur = q.poll();
                if (i==curSize-1) {
                    System.out.print(cur.data + " ");
                }
                if (cur.left!=null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
        }
    }


    // Recursive Solution Using PreOrder and postOrder

    static int maxLevel1 = 0;
    public static void leftViewOfBinaryTreeRec(Node root){
        leftView(root,1);
    }
    private static void leftView(Node root,int level){
        if(root == null) return;
        if (maxLevel1 < level){
            System.out.print(root.data+" ");
            maxLevel1 = level;
        }
        leftView(root.left,level+1);
        leftView(root.right,level+1);
    }
    static int maxLevel2 = 0;
    public static void rightViewOfBinaryTreeRec(Node root){
        rightView(root,1);
    }
    private static void rightView(Node root,int level){
        if(root == null) return;
        if (maxLevel2 < level){
            System.out.print(root.data+" ");
            maxLevel2 = level;
        }
        rightView(root.right,level+1);
        rightView(root.left,level+1);

    }

}
