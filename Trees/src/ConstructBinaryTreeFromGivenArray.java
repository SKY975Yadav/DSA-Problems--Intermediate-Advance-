public class ConstructBinaryTreeFromGivenArray {
    /*
    Given an array of size N that can be used to represents a tree. The array indexes are values in tree nodes and array values give the parent node of that particular index (or node). The value of the root node index would always be -1 as there is no parent for root. Construct the standard linked representation of Binary Tree from this array representation.

Note: If two elements have the same parent, the one that appears first in the array will be the left child and the other is the right child.


Example 1:

Input:
N = 7
parent[] = {-1,0,0,1,1,3,5}
Output: 0 1 2 3 4 5 6
Explanation: the tree generated
will have a structure like
          0
        /   \
       1     2
      / \
     3   4
    /
   5
 /
6
Example 2:

Input:
N = 3
parent[] = {2, 0, -1}
Output: 2 0 1
Explanation: the tree generated will
have a structure like
               2
             /
            0
          /
         1

Your Task:
You don't need to read input or print anything. The task is to complete the function createTree() which takes 2 arguments parent[] and N and returns the root node of the constructed tree.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)
     */
    public static void main(String[] args) {
        int[] parent = {-1,0,0,1,1,3,5};
        Node root = createTree(parent, parent.length);
    }
    public static Node createTree(int[] parent, int N) {
        //Your code here
        if (N == 0) return null;

        // Create an array of nodes for all indices
        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(i);
        }

        Node root = null;

        // Link nodes based on the parent array
        for (int i = 0; i < N; i++) {
            if (parent[i] == -1) {
                root = nodes[i];
            } else {
                Node parentNode = nodes[parent[i]];
                if (parentNode.left == null) {
                    parentNode.left = nodes[i];
                } else {
                    parentNode.right = nodes[i];
                }
            }
        }

        return root;
    }
}
