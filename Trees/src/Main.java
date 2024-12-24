import java.util.ArrayList;
import java.util.*;

public class Main {
    public static void main(String[] args) {

    }

    public static Node getTree() {
        Node root = new Node(20);
        root.left = new Node(70);
        root.right = new Node(10);
        root.left.left = new Node(80);
        root.left.right = new Node(34);
        root.right.left = new Node(84);
        root.right.right = new Node(53);
        return root;
    }

    static int getMaxSum(Node root) {
        if (root == null) {
            return 0;
        }

        // Calculate the maximum sum including the current node
        int incl = root.data;
        if (root.left != null) {
            incl += getMaxSum(root.left.left) + getMaxSum(root.left.right);
        }
        if (root.right != null) {
            incl += getMaxSum(root.right.left) + getMaxSum(root.right.right);
        }

        // Calculate the maximum sum excluding the current node
        int excl = getMaxSum(root.left) + getMaxSum(root.right);

        // Return the maximum of including or excluding the current node
        return Math.max(incl, excl);
    }
}