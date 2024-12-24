public class ConvertBinaryTreeIntoItsMirror {
    public static void main(String[] args) {
        Node root = Main.getTree();
        BinaryTreeTraversal.inOrderTraversal(root);
        mirror(root);
        BinaryTreeTraversal.inOrderTraversal(root);
    }
    static void mirror(Node node) {
        // Your code here
        if(node == null) return;
        if(node.left == null && node.right == null) return;
        mirror(node.left);
        mirror(node.right);
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
