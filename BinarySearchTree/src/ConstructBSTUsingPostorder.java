import java.util.Arrays;
import java.util.HashMap;

public class ConstructBSTUsingPostorder {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        // Note only provide postorder that from binary search tree not randomly
        int [] post = {10,40,30,75,90,80,70,50};
        Node root = buildTree(post);
        bst.inorderTraversal(root);
    }

    private static int ind = 0;
    // Function to return a tree created from postorder and in order traversals.
    static Node buildTree(int[] post) {
        int n = post.length;
        int [] in = new int[n];
        System.arraycopy(post, 0, in, 0, n);
        Arrays.sort(in);
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
