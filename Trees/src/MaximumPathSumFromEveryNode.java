public class MaximumPathSumFromEveryNode {
    public static void main(String[] args) {
        Node root = Main.getTree();
        System.out.println(findMaxSum(root));
    }
    static class Max{
        int max ;
        Max(int m) {max = m;}
    }
    static int findMaxSum(Node root)
    {
        //your code goes here
        Max max = new Max(Integer.MIN_VALUE);
        maxSum(root,max);
        return max.max;
    }

    static private int maxSum(Node root, Max max){
        if(root == null) return 0;

        int left = maxSum(root.left,max);
        int right= maxSum(root.right,max);

        int sum = root.data;
        // Calculate the possible maximum sums involving the current node
        int maxSinglePath = Math.max(sum, Math.max(left, right) + sum);
        int maxTopPath = Math.max(maxSinglePath, left + right + sum);

        // Update the global maximum sum
        max.max = Math.max(max.max, maxTopPath);

        // Return the maximum sum of paths going through the current node
        return maxSinglePath;
    }
}
