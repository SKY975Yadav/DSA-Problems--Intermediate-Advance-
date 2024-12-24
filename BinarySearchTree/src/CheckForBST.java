import java.util.ArrayList;

public class CheckForBST {
    public static void main(String[] args) {

    }
    public static boolean isBST(Node root){
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private static boolean checkBST(Node root, int min, int max)
    {
        if (root == null)
            return true;

        return (root.data>min && root.data<max &&
                checkBST(root.left,min,root.data) && checkBST(root.right,root.data,max));
    }
    static int prev=Integer.MIN_VALUE;
    public static boolean isBSTMeth2(Node root)
    {
        if (root == null)
            return true;

        if(!isBSTMeth2(root.left))return false;

        if(root.data<=prev)return false;
        prev=root.data;

        return isBSTMeth2(root.right);
    }

}
