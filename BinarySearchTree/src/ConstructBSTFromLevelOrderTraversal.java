import java.util.*;

public class ConstructBSTFromLevelOrderTraversal {
    public static void main(String[] args) {

    }
    static class NodeRange {
        Node node;
        int min, max;

        public NodeRange(Node node, int min, int max)
        {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }

    public static Node constructBst(int[] arr)
    {
        if (arr.length == 0)
            return null;

        // Create root node and store a copy of it in head
        Node root = new Node(arr[0]);

        // Create queue to store the tree nodes
        Queue<NodeRange> queue = new LinkedList<>();
        queue.add(new NodeRange(root, Integer.MIN_VALUE,
                Integer.MAX_VALUE));

        for (int i = 1; i < arr.length; i++) {
            NodeRange nr = queue.peek();

            // Check if arr[i] can be a child of the temp
            // node
            if (arr[i] > nr.min && arr[i] < nr.max) {
                // Check if arr[i] can be left child
                if (arr[i] < nr.node.data) {
                    // Set the left child and range
                    nr.node.left = new Node(arr[i]);
                    queue.add(new NodeRange(nr.node.left,
                            nr.min,
                            nr.node.data));
                }
                // Check if arr[i] can be right child
                else {
                    // Pop the temp node from queue, set the
                    // right child and new range
                    queue.remove();
                    nr.node.right = new Node(arr[i]);
                    queue.add(new NodeRange(nr.node.right,
                            nr.node.data,
                            nr.max));
                }
            }
            else {
                queue.remove();
                i--;
            }
        }

        return root;
    }
}
