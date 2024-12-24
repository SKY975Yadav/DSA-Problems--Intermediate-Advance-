public class RedBlackTree {
    static class Node {
        Node left, right, parent;
        int data, color;

        Node(int data) {
            this.data = data;
            this.color = 1; // New node is red
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }
    private Node root;
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
        if (root == null){
            root = new Node(x);
            root.color = 0;
        }
        else {
            Node newNode = new Node(x);
            root = bstInsert(root, newNode);
            fixInsert(newNode);
        }
    }
    private Node bstInsert(Node root, Node newNode) {
        if (root == null)
            return newNode;

        if (newNode.data < root.data) {
            root.left = bstInsert(root.left, newNode);
            root.left.parent = root;
        } else if (newNode.data > root.data) {
            root.right = bstInsert(root.right, newNode);
            root.right.parent = root;
        }

        return root;
    }
    private void fixInsert(Node node) {
        Node parent = null;
        Node grandParent = null;

        while (node != root && node.color != 0 && node.parent.color == 1) {
            parent = node.parent;
            grandParent = parent.parent;

            if (parent == grandParent.left) {
                Node uncle = grandParent.right;

                if (uncle != null && uncle.color == 1) {
                    grandParent.color = 1;
                    parent.color = 0;
                    uncle.color = 0;
                    node = grandParent;
                } else {
                    if (node == parent.right) {
                        leftRotation(parent);
                        node = parent;
                        parent = node.parent;
                    }
                    rightRotation(grandParent);
                    int temp = parent.color;
                    parent.color = grandParent.color;
                    grandParent.color = temp;
                    node = parent;
                }
            } else {
                Node uncle = grandParent.left;

                if (uncle != null && uncle.color == 1) {
                    grandParent.color = 1;
                    parent.color = 0;
                    uncle.color = 0;
                    node = grandParent;
                } else {
                    if (node == parent.left) {
                        rightRotation(parent);
                        node = parent;
                        parent = node.parent;
                    }
                    leftRotation(grandParent);
                    int temp = parent.color;
                    parent.color = grandParent.color;
                    grandParent.color = temp;
                    node = parent;
                }
            }
        }

        root.color = 0;
    }
    private void leftRotation(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;

        if (node.right != null)
            node.right.parent = node;

        rightChild.parent = node.parent;

        if (node.parent == null)
            root = rightChild;
        else if (node == node.parent.left)
            node.parent.left = rightChild;
        else
            node.parent.right = rightChild;

        rightChild.left = node;
        node.parent = rightChild;
    }
    private void rightRotation(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;

        if (node.left != null)
            node.left.parent = node;

        leftChild.parent = node.parent;

        if (node.parent == null)
            root = leftChild;
        else if (node == node.parent.left)
            node.parent.left = leftChild;
        else
            node.parent.right = leftChild;

        leftChild.right = node;
        node.parent = leftChild;
    }
    public void delete(int data) {
        Node node = bstDelete(root, data);
        fixDelete(node);
    }
    private Node bstDelete(Node root, int data) {
        if (root == null) return null;

        if (data < root.data) {
            root.left = bstDelete(root.left, data);
        } else if (data > root.data) {
            root.right = bstDelete(root.right, data);
        } else {
            if (root.left == null || root.right == null) {
                return root;
            }
            Node min = findMin(root.right);
            root.data = min.data;
            root.right = bstDelete(root.right, min.data);
        }
        return root;
    }
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    private void fixDelete(Node node) {
        while (node != root && node.color == 0) {
            if (node == node.parent.left) {
                Node sibling = node.parent.right;

                if (sibling.color == 1) {
                    sibling.color = 0;
                    node.parent.color = 1;
                    leftRotation(node.parent);
                    sibling = node.parent.right;
                }

                if ((sibling.left == null || sibling.left.color == 0) &&
                        (sibling.right == null || sibling.right.color == 0)) {
                    sibling.color = 1;
                    node = node.parent;
                } else {
                    if (sibling.right == null || sibling.right.color == 0) {
                        sibling.left.color = 0;
                        sibling.color = 1;
                        rightRotation(sibling);
                        sibling = node.parent.right;
                    }
                    sibling.color = node.parent.color;
                    node.parent.color = 0;
                    if (sibling.right != null) sibling.right.color = 0;
                    leftRotation(node.parent);
                    node = root;
                }
            } else {
                Node sibling = node.parent.left;

                if (sibling.color == 1) {
                    sibling.color = 0;
                    node.parent.color = 1;
                    rightRotation(node.parent);
                    sibling = node.parent.left;
                }

                if ((sibling.left == null || sibling.left.color == 0) &&
                        (sibling.right == null || sibling.right.color == 0)) {
                    sibling.color = 1;
                    node = node.parent;
                } else {
                    if (sibling.left == null || sibling.left.color == 0) {
                        sibling.right.color = 0;
                        sibling.color = 1;
                        leftRotation(sibling);
                        sibling = node.parent.left;
                    }
                    sibling.color = node.parent.color;
                    node.parent.color = 0;
                    if (sibling.left != null) sibling.left.color = 0;
                    rightRotation(node.parent);
                    node = root;
                }
            }
        }
        node.color = 0;
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
        RedBlackTree tree = new RedBlackTree();
        tree.insert(10);
        tree.insert(50);
        tree.insert(83);
        System.out.println(tree.search(50));
        tree.preOrder();
    }
}

