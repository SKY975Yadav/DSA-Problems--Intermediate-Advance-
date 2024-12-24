
public class BinarySearchTree {
    public Node getRoot(int x){
        return new Node(x);
    }
    public boolean search(Node root,int key){//TC : O(h) , SC : O(h)
        if(root == null) return false;
        if (root.data==key) return true;
        else if(root.data>key){
            return search(root.left,key);
        }
        else return search(root.right,key);
    }
    public boolean searchIterative(Node root, int x){
        while(root!=null){
            if(root.data==x)
                return true;
            else if(root.data<x)
                root=root.right;
            else
                root=root.left;
        }
        return false;
    }
    public Node insert(Node root,int x){
        if (root==null) return new Node(x);
        if (root.data>x) root.left= insert(root.left,x);
        else if (root.data<x) root.right =  insert(root.right,x);
        return root;
    }
    public Node insertIterative(Node root,int x){
        Node temp = new Node(x);
        Node cur = root,parent = null;
        while (cur!=null){
            parent= cur;
            if (cur.data>x) cur = cur.left;
            else if (cur.data<x) cur = cur.right;
            else return root;
        }
        if (parent == null) return temp;
        if (parent.data<x) parent.right = temp;
        else parent.left = temp;
        return root;
    }
    public Node delete(Node root,int x){
        if (root==null) return null;
        if (root.data>x) root.left = delete(root.left,x);
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
    public Node deleteIterative(Node root, int key) {
        if (root == null) {
            return root;
        }

        Node parent = null;
        Node current = root;

        // Find the node to be deleted and its parent
        while (current != null && current.data != key) {
            parent = current;
            if (key < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null) {
            // Key not found
            return root;
        }

        // Case 1: Node to be deleted is a leaf node
        if (current.left == null && current.right == null) {
            if (current != root) {
                if (parent.left == current) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else {
                root = null;
            }
        }

        // Case 2: Node to be deleted has only one child
        else if (current.left == null || current.right == null) {
            Node child = (current.left != null) ? current.left : current.right;

            if (current != root) {
                if (current == parent.left) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            } else {
                root = child;
            }
        }

        // Case 3: Node to be deleted has two children
        else {
            Node successorParent = current;
            Node successor = current.right;

            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            current.data = successor.data;

            if (successorParent != current) {
                successorParent.left = successor.right;
            } else {
                successorParent.right = successor.right;
            }
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
    public Node deleteByChangingLinks(Node root, int data) { // By changing links
        if (root == null) return null;

        Node parent = null;
        Node current = root;

        // Find the node to be deleted and its parent
        while (current != null && current.data != data) {
            parent = current;
            if (data < current.data)
                current = current.left;
            else
                current = current.right;
        }

        // If the data is not found in the tree
        if (current == null) return root;

        // Node with only one child or no child
        if (current.left == null || current.right == null) {
            Node newCurrent;

            if (current.left == null)
                newCurrent = current.right;
            else
                newCurrent = current.left;

            // If the node to be deleted is the root node
            if (parent == null)
                return newCurrent;

            // If the node to be deleted is not the root node
            if (current == parent.left)
                parent.left = newCurrent;
            else
                parent.right = newCurrent;
        } else {
            // Node with two children: Find the inorder successor (smallest in the right subtree)
            Node successorParent = current;
            Node successor = current.right;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            // Link successor's right subtree to its parent
            if (successorParent != current)
                successorParent.left = successor.right;
            else
                successorParent.right = successor.right;

            // Replace current with successor
            successor.left = current.left;
            successor.right = current.right;

            if (parent == null)
                return successor;

            if (current == parent.left)
                parent.left = successor;
            else
                parent.right = successor;
        }
        return root;
    }
    public Node floor(Node root,int x){//floor means Node of  smaller or equal number
        if (root==null) return null;
        Node res= null;
        while (root!=null) {
            if (root.data == x) return root;
            if (root.data > x) root = root.left;
            else {
                res = root;
                root = root.right;
            }
        }
        return res;
    }
    public Node ciel(Node root,int x){//floor means Node of  smaller or equal number
        if (root==null) return null;
        Node res= null;
        while (root!=null) {
            if (root.data == x) return root;
            if (root.data < x) root = root.right;
            else {
                res = root;
                root = root.left;
            }
        }
        return res;
    }
    public int maxInBST(Node root){
        if (root == null)return -1;
        Node cur = root;
        while (cur.right!=null){
            cur=cur.right;
        }
        return cur.data;
    }
    public int minInBST(Node root){
        if (root == null)return -1;
        Node cur = root;
        while (cur.left!=null){
            cur=cur.left;
        }
        return cur.data;
    }
    public void inorderTraversal(Node root){
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.data+" ");
        inorderTraversal(root.right);
    }
    public void preorderTraversal(Node root){
        if (root == null) return;
        System.out.print(root.data+" ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
    public void postorderTraversal(Node root){
        if (root == null) return;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data+" ");
    }
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Initialize root
        Node root = bst.getRoot(40);

        //Insert Elements
        bst.insert(root,50);
        bst.insert(root,20);
        bst.insert(root,10);
        bst.insert(root,19);
        bst.insert(root,26);

        bst.insertIterative(root,45);
        bst.insertIterative(root,15);
        bst.insertIterative(root,25);
        bst.insertIterative(root,62);
        bst.insertIterative(root,13);

        System.out.print("Inorder Traversal : ");
        bst.inorderTraversal(root);
        System.out.println();

        System.out.print("Preorder Traversal : ");
        bst.preorderTraversal(root);
        System.out.println();

        System.out.print("Postorder Traversal : ");
        bst.postorderTraversal(root);
        System.out.println();

        // Search
        System.out.println("Search 50 : "+bst.searchIterative(root,50));
        System.out.println("Search 1005 : "+bst.search(root,1005));

        // Delete
        root = bst.delete(root,25);
        System.out.print("After deleting 25 : ");
        bst.inorderTraversal(root);
        System.out.println();

        root = bst.deleteIterative(root,50);
        System.out.print("After deleting 50 : ");
        bst.inorderTraversal(root);
        System.out.println();

        root = bst.deleteByChangingLinks(root,40);
        System.out.print("After deleting 40 : ");
        bst.inorderTraversal(root);
        System.out.println();

        //Floor
        System.out.println("floor of 14 : "+bst.floor(root,14).data);
        System.out.println("floor of 65 : "+bst.floor(root,65).data);

        // Ciel
        System.out.println("ciel of 14 : "+bst.ciel(root,14).data);
        System.out.println("ciel of -1 : "+bst.ciel(root,-1).data);

        // Min and Max
        System.out.println("Max :"+bst.maxInBST(root));
        System.out.println("Min :"+bst.minInBST(root));

    }
}
