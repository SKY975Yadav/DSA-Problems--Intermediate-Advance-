import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class ConstructBSTUsingPreorder {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        // Note only provide preorder that from binary search tree not randomly
        int [] pre = {50,30,10,40,70,80,75,90};
        Node root = binaryTreeUsingIOAndPO(pre);
        bst.inorderTraversal(root);
    }
    public static Node binaryTreeUsingIOAndPO(int [] pre){ // This solution only work for distinct elements
        int n = pre.length;
        int [] in = new int[n];
        System.arraycopy(pre, 0, in, 0, n);
        Arrays.sort(in);
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i < n;i++){
            map.put(in[i],i);
        }
        return helper(pre,0,n-1,map);
    }
    static int preIndex=0;
    private static Node helper(int [] pre, int start, int end, HashMap<Integer,Integer> map){
        if(start>end)return null;
        Node root=new Node(pre[preIndex++]);

        int inIndex=map.get(root.data);

        root.left=helper(pre, start, inIndex-1,map);
        root.right=helper(pre, inIndex+1, end,map);
        return root;
    }
}
