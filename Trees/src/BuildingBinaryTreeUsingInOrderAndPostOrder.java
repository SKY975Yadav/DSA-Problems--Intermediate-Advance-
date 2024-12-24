import java.util.HashMap;

public class BuildingBinaryTreeUsingInOrderAndPostOrder {
    public static void main(String[] args) {
        int [] in = {4, 8, 2, 5, 1, 6, 3, 7};
        int [] post = {8, 4, 5, 2, 6, 7, 3, 1};
        Node root = buildTree(in.length,in,post);
        BinaryTreeTraversal.inOrderTraversalInIterative(root);

    }

    private static int ind = 0;
    // Function to return a tree created from postorder and in order traversals.
   static Node buildTree(int n, int[] in, int[] post) {
        ind = n - 1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i< n;i++){
            map.put(in[i],i);
        }
        return helper(post,0,n-1,map);
    }

    static private Node helper(int [] post,int start,int end,HashMap<Integer,Integer> map){

        if(start>end) return null;

        Node root = new Node(post[ind--]);
        int mid = map.get(root.data);

        root.right = helper(post,mid+1,end,map);
        root.left = helper(post,start,mid-1,map);

        return root;
    }
}
