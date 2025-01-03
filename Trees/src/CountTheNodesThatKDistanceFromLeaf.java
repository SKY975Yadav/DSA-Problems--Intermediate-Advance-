import java.util.*;

public class CountTheNodesThatKDistanceFromLeaf {
    /*
    Given a binary tree with n nodes and a non-negative integer k, the task is to count the number of special nodes.
A node is considered special if there exists at least one leaf in its subtree such that the distance between the node and leaf is exactly k.
Note: Any such node should be counted only once. For example, if a node is at a distance k from 2 or more leaf nodes, then it would add only 1 to our count.

Example 1:

Input:
Binary tree
        1
      /   \
     2     3
   /  \   /  \
  4   5  6    7
          \
           8
k = 2
Output:
2
Explanation:
There are only two unique nodes that are at a distance of 2 units from the leaf node. (node 3 for leaf with value 8 and node 1 for leaves with values 4, 5 and 7) Note that node 2 isn't considered for leaf with value 8 because it isn't a direct ancestor of node 8.
Example 2:

Input:
Binary tree
          1
         /
        3
       /
      5
    /  \
   7    8
         \
          9
k = 4
Output:
1
Explanation:
Only one node is there which is at a distance of 4 units from the leaf node.(node 1 for leaf with value 9)
Your Task:
You don't have to read input or print anything. Complete the function printKDistantFromLeaf() that takes root node and k as inputs and returns the number of nodes that are at distance k from a leaf node.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(Height of the Tree).
     */
    public static void main(String[] args) {
        Node root = Main.getTree();
        root.left.left.right = new Node(34);
        System.out.println(printKDistantFromLeaf(root,2));
    }
    static HashSet<Node> set = new HashSet<>();
    static int count = 0;
    static int printKDistantFromLeaf(Node root, int k)
    {
        // Write your code here
        set.clear();
        count = 0;
        findKDistanceFromLeaf(root, k, new Node[1000], 0);
        return count;

    }

    static private void findKDistanceFromLeaf(Node node, int k, Node[] path, int pathLen) {
        if (node == null) return;

        // Add current node to the path
        path[pathLen] = node;
        pathLen++;

        // If it's a leaf node
        if (node.left == null && node.right == null) {
            // Check if there's a node k distance from the leaf
            if (pathLen - k - 1 >= 0 && !set.contains(path[pathLen - k - 1])) {
                // Add this node to the set to avoid duplicate counts
                set.add(path[pathLen - k - 1]);
                count++;
            }
        }

        // Recur for left and right subtrees
        findKDistanceFromLeaf(node.left, k, path, pathLen);
        findKDistanceFromLeaf(node.right, k, path, pathLen);
    }
}
