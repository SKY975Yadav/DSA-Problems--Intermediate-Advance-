public class ProgrammingProblemMaximumSumOfNonAdjacentNodesDynamic {
    /*
    Given a binary tree with a value associated with each node, we need to choose a subset of these nodes such that sum of chosen nodes is maximum under a constraint that no two chosen node in subset should be directly connected that is, if we have taken a node in our sum then we can’t take its any children or parents in consideration and vice versa.



Example 1:

Input:
     11
    /  \
   1    2
Output: 11
Explanation: The maximum sum is sum of
node 11.
Example 2:

Input:
        1
      /   \
     2     3
    /     /  \
   4     5    6
Output: 16
Explanation: The maximum sum is sum of
nodes 1 4 5 6 , i.e 16. These nodes are
non adjacent.
Your Task:
You don't need to read input or print anything. You just have to complete function getMaxSum() which accepts root node of the tree as parameter and returns the maximum sum as described.

Expected Time Complexity: O(Number of nodes in the tree).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 ≤ Number of nodes in the tree ≤ 10000
1 ≤ Value of each node ≤ 100000
     */
    public static void main(String[] args) {

        Node root = Main.getTree();
        System.out.println(getMaxSum(root));
    }
    static class Res {
        int incl;
        int excl;
        Res(int incl, int excl) {
            this.incl = incl;
            this.excl = excl;
        }
    }

    static int getMaxSum(Node root)
    {
        // add your code here
        Res res = getMaxSumHelper(root);
        return Math.max(res.incl, res.excl);
    }

    static Res getMaxSumHelper(Node node) {
        if (node == null) {
            return new Res(0, 0);
        }

        Res leftRes = getMaxSumHelper(node.left);
        Res rightRes = getMaxSumHelper(node.right);

        // If we include this node, we cannot include its children
        int incl = node.data + leftRes.excl + rightRes.excl;

        // If we exclude this node, we can take the maximum of including or excluding its children
        int excl = Math.max(leftRes.incl, leftRes.excl) + Math.max(rightRes.incl, rightRes.excl);

        return new Res(incl, excl);
    }

}
