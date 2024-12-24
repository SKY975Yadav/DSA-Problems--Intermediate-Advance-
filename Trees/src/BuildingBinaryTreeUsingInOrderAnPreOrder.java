import java.util.HashMap;

public class BuildingBinaryTreeUsingInOrderAnPreOrder {
    public static void main(String[] args) {
//        int [] in = {40,20,50,10,30,80,70,90};
//        int [] pre = {10,20,40,50,30,70,80,90};
        int [] in = {3,2,8,6,10,12,14,13,4};
        int [] pre = {10,3,8,2,6,4,12,13,14};
        Node root = binaryTreeUsingIOAndPO(in,pre);
        BinaryTreeTraversal.inOrderTraversal(root);
        System.out.println();
        BinaryTreeTraversal.preOrderTraversal(root);
    }

    public static Node binaryTreeUsingIOAndPO(int [] in, int [] pre){ // This solution only work for distinct elements
        int n = in.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i< n;i++){
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
