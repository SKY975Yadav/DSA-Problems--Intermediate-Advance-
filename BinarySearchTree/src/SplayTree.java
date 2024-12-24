public class SplayTree {
    static class Node {
        Node left, right, parent;
        int data;
        Node(int data) {
            this.data = data;
            left = right = parent = null;
        }
    }

    private Node root;
    private void updateParent(Node child, Node parent) {
        if (child != null) {
            child.parent = parent;
        }
    }
    private Node zig(Node x) {
        Node y = x.left;
        Node T2 = y.right;

        y.right = x;
        x.left = T2;

        updateParent(y,x.parent);
        updateParent(T2, x);
        updateParent(x, y);

        return y;
    }
    private Node zag(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        updateParent(y,x.parent);
        updateParent(T2, x);
        updateParent(x, y);

        return y;
    }
    public boolean search(int x){
        return search(root,x);
    }
    private boolean search(Node root, int key){//TC : O(h) , SC : O(h)
        if(root == null) return false;
        if (root.data==key) return true;
        else if(root.data>key){
            return search(root.left,key);
        }
        else return search(root.right,key);
    }
    public void insert(int x) {
        root = insert(root, x);
    }

    private Node insert(Node root, int x) {
        if (root == null) return new Node(x);

        Node cur = root, parent = null;
        while (cur != null) {
            parent = cur;
            if (x < cur.data) {
                cur = cur.left;
            } else if (x > cur.data) cur = cur.right;
            else return splay(root, cur); // Splay the existing node to root
        }

        Node newNode = new Node(x);
        if (x < parent.data) parent.left = newNode;
        else parent.right = newNode;
        newNode.parent = parent;
        return splay(root, newNode);
    }

    public void delete(int x) {
        root = delete(root, x);
    }

    private Node delete(Node root, int x) {
        if (root == null) return null;

        root = splay(root, findNode(root, x));
        if (root.data != x) return root; // x not found

        if (root.left == null) {
            root = root.right;
            if (root != null) root.parent = null;
        } else {
            Node leftSubtree = root.left;
            leftSubtree.parent = null;

            Node newRoot = splay(leftSubtree, findMax(leftSubtree));
            newRoot.right = root.right; // Attach the right subtree
            if (root.right != null) newRoot.right.parent = newRoot;
            root = newRoot;
        }
        return root;
    }

    private Node findNode(Node root, int x) {
        Node cur = root;
        while (cur != null) {
            if (x < cur.data) {
                cur = cur.left;
            } else if (x > cur.data) {
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return cur;
    }

    private Node findMax(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    private Node splay(Node root, Node newNode) {
        if (newNode == null) return root;

        while (newNode.parent != null) {
            if (newNode.parent == root) {
                if (newNode == root.left) root = zig(newNode.parent); // Right Rotation
                else root = zag(newNode.parent); // Left Rotation
            }
            else {
                Node parent = newNode.parent;
                Node grandParent = parent.parent;

                if (newNode == parent.left && parent == grandParent.left) {
                    zig(grandParent); // Right rotation
                    root = zig(parent); // Right rotation
                } else if (newNode == parent.right && parent == grandParent.right) {
                    zag(grandParent); // Left rotation
                    root = zag(parent); // Left rotation
                } else if (newNode == parent.left && parent == grandParent.right) {
                    grandParent.right = zig(parent); // Right rotation
                    root = zag(grandParent); // Left rotation
                } else {
                    grandParent.left = zag(parent); // Left rotation
                    root = zig(grandParent); // Right rotation
                }
            }
        }
        return newNode;
    }

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
        SplayTree tree = new SplayTree();
        tree.insert(34);
        tree.insert(25);
        tree.insert(78);

        tree.preOrder();
        tree.delete(25);
        tree.preOrder();

        System.out.println(tree.search(25));
        System.out.println(tree.search(34));
    }
}
