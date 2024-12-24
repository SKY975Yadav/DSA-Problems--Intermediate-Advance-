public class MaxDifferenceBetweenNodeAndItsAncestor {
    public static void main(String[] args) {
        Node root = Main.getTree();
        System.out.println(maxDiff(root));
    }
    static class MaxDiff{
        int maxDiff;
        MaxDiff(int m){maxDiff = m;}
    }
    static int maxDiff(Node root)
    {
        //your code here
        if(root == null) return Integer.MIN_VALUE;
        MaxDiff md = new MaxDiff(Integer.MIN_VALUE);
        getMaxDiff(root,md);
        return md.maxDiff;
    }

    static private int getMaxDiff(Node root, MaxDiff md){

        if(root == null) return Integer.MAX_VALUE;

        if(root.left == null && root.right == null) return root.data;

        int left = getMaxDiff(root.left,md);
        int right = getMaxDiff(root.right,md);

        int data = root.data;

        int min = Math.min(left,right);

        md.maxDiff = Math.max(md.maxDiff , data - min );

        return Math.min(data,Math.min(left,right));

    }
}
