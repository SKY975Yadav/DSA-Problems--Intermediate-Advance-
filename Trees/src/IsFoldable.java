public class IsFoldable {
    public static void main(String[] args) {
        Node root = Main.getTree();
        System.out.println(isFoldable(root));
    }
    static boolean isFoldable(Node root)
    {
        // your code
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }
    static private boolean isMirror(Node n1, Node n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }
        return isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left);
    }
}
