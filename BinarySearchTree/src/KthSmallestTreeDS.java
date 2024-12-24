public class KthSmallestTreeDS {
    public static void main(String[] args) {
        // Design a data structure that support insertion deletion and search and Kth smallest number efficiently
         KthSmallestTreeDS kso = new KthSmallestTreeDS();
        Node root = new Node(20);
        kso.insert(root,15);
        kso.insert(root,25);
        kso.insert(root,18);
        kso.insert(root,10);
        kso.insert(root,21);
        kso.insert(root,28);
        kso.insert(root,5);
        kso.insert(root,13);
        kso.insert(root,26);
        kso.insert(root,30);
//        kso.inorderTraversal(root);
        System.out.println(kso.kthSmallest(root,9));
    }
    static class Node{
        Node left,right;
        int data,count;
        Node(int x){
            data = x;
            count = 0;
            left = right = null;
        }
    }
    public boolean search(Node root, int key){//TC : O(h) , SC : O(h)
        if(root == null) return false;
        if (root.data==key) return true;
        else if(root.data>key){
            return search(root.left,key);
        }
        else return search(root.right,key);
    }
    private Node insert(Node root, int x){
        if (root==null) return new Node(x);
        if (root.data>x) {
            root.left= insert(root.left,x);
            root.count++;
        }
        else if (root.data<x) root.right =  insert(root.right,x);
        return root;
    }
    public Node delete(Node root, int x){
        if (root==null) return null;
        if (root.data>x) {
            root.left = delete(root.left, x);
            root.count--;
        }
        else if (root.data<x) root.right = delete(root.right,x);
        else {
            if (root.left==null) return root.right;
            if (root.right==null) return root.left;
            Node suc =findInorderSuccessor(root);
            root.data = suc.data;
            root.right = delete(root.right, suc.data);
        }
        return root;
    }
    private Node findInorderSuccessor(Node root){
        Node cur = root.right;
        while (cur!=null && cur.left!=null){
            cur =cur.left;
        }
        return cur;
    }
    public int kthSmallest(Node root , int k){
        Node cur = root;
        while (cur != null){
            if ( k == cur.count + 1){
                return cur.data;
            }
            if (k < cur.count+1){
                cur = cur.left;
            }
            if (k > cur.count+1){
                k = k - (cur.count+1);
                cur = cur.right;
            }
        }
        return  Integer.MIN_VALUE;
    }
    public void inorderTraversal(Node root){
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print("{ "+root.data+", "+root.count+" }");
        inorderTraversal(root.right);
    }

}

