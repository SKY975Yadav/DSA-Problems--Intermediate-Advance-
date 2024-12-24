public class CheckForBalancingBinaryTree {
    public static void main(String[] args) {
        Node root = Main.getTree();
        System.out.println(isBalanceBinaryTree(root));
        root.left.left.left = new Node(34);
        root.left.left.left.left = new Node(454);
        System.out.println(isBalanceBinaryTree(root));

    }
    public static boolean isBalanceBinaryTree(Node root){
        return !(isBalance(root) == -1);
    }
    private static int isBalance(Node root){
        if (root == null) return 0;
        int leftHeight = isBalance(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = isBalance(root.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight,rightHeight)+1;
    }
}
