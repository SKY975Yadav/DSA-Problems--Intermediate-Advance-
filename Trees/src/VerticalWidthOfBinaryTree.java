public class VerticalWidthOfBinaryTree {

    public static void main(String[] args) {
        Node root = Main.getTree();
        System.out.println(verticalWidth(root));
    }
    static class MinMax {
        int min;
        int max;
    }

    // Helper function to find the min and max horizontal distances
    private static void findMinMax(Node node, MinMax minMax, int hd) {
        if (node == null) {
            return;
        }

        // Update min and max
        if (hd < minMax.min) {
            minMax.min = hd;
        }
        if (hd > minMax.max) {
            minMax.max = hd;
        }

        // Recur for left and right subtrees
        findMinMax(node.left, minMax, hd - 1);
        findMinMax(node.right, minMax, hd + 1);
    }
    public static int verticalWidth(Node root)
    {
        // code here.
        if (root == null) {
            return 0;
        }

        MinMax minMax = new MinMax();
        minMax.min = 0;
        minMax.max = 0;

        // Find the min and max horizontal distance
        findMinMax(root, minMax, 0);

        // The vertical width is max - min + 1
        return (minMax.max - minMax.min + 1);
    }
}
