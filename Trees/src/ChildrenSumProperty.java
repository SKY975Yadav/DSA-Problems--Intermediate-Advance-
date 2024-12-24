public class ChildrenSumProperty {
    public static void main(String[] args) {
        Node root = Main.getTree();
        System.out.println(isChildrenSumProperty(root));

        Node root1 = new Node(10);
        root1.left = new Node(6);
        root1.right = new Node(4);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);
        root1.right.left = new Node(1);
        root1.right.right = new Node(3);
        System.out.println(isChildrenSumProperty(root1));

    }
    public static boolean isChildrenSumProperty(Node root){
        if(root==null) return true;
        if (root.left == null && root.right == null) return true;
        int sum = 0;
        if (root.left != null) sum += root.left.data;
        if (root.right != null) sum += root.right.data;
        return ((root.data == sum) && isChildrenSumProperty(root.left) && isChildrenSumProperty(root.right));
    }
    
}
