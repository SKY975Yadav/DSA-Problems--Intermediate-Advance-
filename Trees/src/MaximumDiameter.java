public class MaximumDiameter {
    static int diameter = 0;
    public static void main(String[] args) {
//        Node root = Main.getTree();
//        root.left.left.right = new Node(23);
//        root.right.left.right = new Node(57);
//        root.right.left.right.left = new Node(32);
//        root.right.left.right.left.right = new Node(432);
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        System.out.println(maxDiameter(root));
        System.out.println(maximumDiameter(root));

    }
    public static int maxDiameter(Node root){
        maximumDiameter(root);
        return diameter-1;
    }

    private static int maximumDiameter(Node root){

        if (root == null ) return 0;
        int leftHeight = maximumDiameter(root.left)+1;
        int rightHeight = maximumDiameter(root.right)+1;

        diameter = Math.max(diameter,leftHeight + rightHeight -1);

        return Math.max(leftHeight,rightHeight);
    }
}
