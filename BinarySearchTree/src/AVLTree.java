
public class AVLTree {
    static class Node {
        int data, height;
        Node left, right;

        Node(int d) {
            data = d;
            height = 1;
        }
    }
    // Node class representing each Node in the tree
    private Node root;
    // Function to get the height of the tree
    private int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }
    // Function to get the maximum of two integers
    private int max(int a, int b) {
        return Math.max(a, b);
    }
    // Function to right rotate subtree rooted with y
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }
    // Function to left rotate subtree rooted with x
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }
    // Get Balance factor of Node N
    private int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }
    // Function to reBalance the Node
    private Node reBalance(Node Node, int data) {
        int balance = getBalance(Node);

        // Left Left Case
        if (balance > 1 && data < Node.left.data)
            return rightRotate(Node);

        // Right Right Case
        if (balance < -1 && data > Node.right.data)
            return leftRotate(Node);

        // Left Right Case
        if (balance > 1 && data > Node.left.data) {
            Node.left = leftRotate(Node.left);
            return rightRotate(Node);
        }

        // Right Left Case
        if (balance < -1 && data < Node.right.data) {
            Node.right = rightRotate(Node.right);
            return leftRotate(Node);
        }

        return Node;
    }
    public boolean search(int x) {
        return search(root, x);
    }
    private boolean search(Node root, int key) {//TC : O(h) , SC : O(h)
        if (root == null) return false;
        if (root.data == key) return true;
        else if (root.data > key) {
            return search(root.left, key);
        } else return search(root.right, key);
    }
    public void insert(int x) {
        root = insert(root, x);
    }
    // Function to insert a data in the subtree rooted with Node and returns the new root of the subtree.
    private Node insert(Node Node, int data) {
        // Perform the normal BST insertion
        if (Node == null)
            return (new Node(data));

        if (data < Node.data)
            Node.left = insert(Node.left, data);
        else if (data > Node.data)
            Node.right = insert(Node.right, data);
        else // Duplicate datas not allowed
            return Node;

        // Update height of this ancestor Node
        Node.height = 1 + max(height(Node.left), height(Node.right));

        // ReBalance the Node
        return reBalance(Node, data);
    }
    // Function to delete a data from the subtree rooted with Node and returns the new root of the subtree.
    public void delete(int x) {
        root = deleteNode(root, x);
    }
    private Node deleteNode(Node root, int data) {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (root == null)
            return null;

        // If the data to be deleted is smaller than the root's data, then it lies in left subtree
        if (data < root.data)
            root.left = deleteNode(root.left, data);

            // If the data to be deleted is greater than the root's data, then it lies in right subtree
        else if (data > root.data)
            root.right = deleteNode(root.right, data);

            // if data is same as root's data, then this is the Node to be deleted
        else {
            // Node with only one child or no child
            if ((root.left == null) || (root.right == null)) {
                Node temp = null;
                if (null == root.left)
                    temp = root.right;
                else
                    temp = root.left;

                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else // One child case
                    root = temp; // Copy the contents of the non-empty child
            } else {
                // Node with two children: Get the inorder successor (smallest in the right subtree)
                Node temp = minValueNode(root.right);

                // Copy the inorder successor's data to this Node
                root.data = temp.data;

                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.data);
            }
        }

        // If the tree had only one Node then return
        if (root == null)
            return null;

        // STEP 2: UPDATE HEIGHT OF THE CURRENT Node
        root.height = max(height(root.left), height(root.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS Node (to check whether this Node became unbalanced)
        return reBalance(root, data);
    }
    // Function to get the inorder successor
    private Node minValueNode(Node Node) {
        Node current = Node;

        /* loop down to find the leftmost leaf */
        while (current.left != null)
            current = current.left;

        return current;
    }
    // A utility function to print preorder traversal of the tree.
    // The function also prints height of every Node
    public void preOrder() {
        preOrder(root);
        System.out.println();
    }
    public void inOrder() {
        inOrder(root);
        System.out.println();

    }
    public void postOrder() {
        postOrder(root);
        System.out.println();

    }
    private void preOrder(Node Node) {
        if (Node != null) {
            System.out.print(Node.data + " ");
            preOrder(Node.left);
            preOrder(Node.right);
        }
    }

    private void inOrder(Node Node) {
        if (Node != null) {
            System.out.print(Node.data + " ");
            inOrder(Node.left);
            inOrder(Node.right);
        }
    }

    private void postOrder(Node Node) {
        if (Node != null) {
            System.out.print(Node.data + " ");
            postOrder(Node.left);
            postOrder(Node.right);
        }
    }
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        /* Constructing tree given in the above figure */
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);


        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        System.out.println("Preorder traversal of constructed tree is : ");
        tree.preOrder();
        System.out.println(tree.search(20));
        tree.delete(10);

        /* The AVL Tree after deletion of 10
             30
            /  \
          20   40
            \     \
            25    50
        */
        System.out.println("\nPreorder traversal after deletion of 10 :");
        tree.preOrder();
        tree.inOrder();
        tree.postOrder();

    }
}
