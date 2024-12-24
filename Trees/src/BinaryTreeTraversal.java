import java.util.*;

class BinaryTreeTraversal{
    public static void main(String[] args) {
        Node root = Main.getTree();
        System.out.println("Inorder Traversal :");
        inOrderTraversal(root);
        System.out.println();
        inOrderTraversalInIterative(root);
        System.out.println("\n");

        System.out.println("PreOrder Traversal");
        preOrderTraversal(root);
        System.out.println();
        preOrderTraversalInIterative(root);
        System.out.println("\n");

        System.out.println("PostOrder Traversal");
        postOrderTraversal(root);
        System.out.println();
        postOrderTraversalInIterative(root);
        System.out.println("\n");

        System.out.println("Level Order Traversal");
        levelOrderTraversal(root);
        System.out.println("\n");
        System.out.println("Level Order Traversal Line by Line");
        levelOrderTraversalLineByLine(root);
        System.out.println();

        System.out.println("Height of the tree : "+height(root));
        System.out.println("Size of the tree : "+size(root));
        System.out.println();

        System.out.println("Spiral Traversal : ");
        spiralTraverseUsingStacks(root);
        System.out.println();

        int num = 34;
        ArrayList<Node> al = new ArrayList<>();
        System.out.println("Find path for given num : "+num);
        findPath(root,al,num);
        al.forEach(x-> System.out.print(x.data+" "));

    }

    //Using Recursion TC : O(N), SC : O(H)
    public static void inOrderTraversal(Node root){
        if (root==null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);
    }
    public static void preOrderTraversal(Node root){
        if (root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    public static void postOrderTraversal(Node root){
        if (root==null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data+" ");
    }
    public static void inOrderTraversalInIterative(Node root){
        if (root==null) return;
        Stack<Node> st = new Stack<>();
        Node cur = root;
        while (cur!=null || !st.isEmpty()){
            while ((cur!=null)){
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            System.out.print(cur.data+" ");
            cur = cur.right;
        }
    }
    public static void preOrderTraversalInIterative(Node root){
        if (root==null) return;
        Stack<Node> st = new Stack<>();
        Node cur = root;
        while (cur!=null || !st.isEmpty()){
            while ((cur!=null)){
                System.out.print(cur.data+" ");
                if (cur.right != null){
                    st.push(cur.right);
                }
                cur = cur.left;
            }
            if (!st.isEmpty()){
                cur = st.pop();
            }
        }
    }
    public static void postOrderTraversalInIterative(Node root) {
        if (root == null) return;
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node current = stack1.pop();
            stack2.push(current);

            if (current.left != null)
                stack1.push(current.left);
            if (current.right != null)
                stack1.push(current.right);
        }
        while (!stack2.isEmpty()) {
            Node current = stack2.pop();
            System.out.print(current.data + " ");
        }
    }
    public static int height(Node root){
        if (root == null) return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }
    private static int size(Node root){
        if (root == null) return 0;
        return 1 + size(root.left)+size(root.right);
    }
    public static void levelOrderTraversal(Node root){
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node cur = q.poll();
            System.out.print(cur.data+" ");
            if (cur.left!=null){
                q.add(cur.left);
            }
            if (cur.right!=null){
                q.add(cur.right);
            }
        }
    }
    public static void levelOrderTraversalLineByLine(Node root){
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int curSize = q.size();
            for (int i = 0; i < curSize; i++) {
                Node cur = q.poll();
                System.out.print(cur.data+" ");
                if (cur.left!=null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            System.out.println();
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
    private static boolean findPath(Node root, ArrayList<Node> al, int n){ // Helper function for above code
        if (root== null) return false;
        al.add(root);
        if (root.data == n) return true;
        if (findPath(root.left,al,n) || findPath(root.right,al,n)) return true;
        al.remove(al.size()-1);
        return false;
    }
}
