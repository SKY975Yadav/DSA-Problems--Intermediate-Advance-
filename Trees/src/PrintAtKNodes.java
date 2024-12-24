public class PrintAtKNodes {
    public static void main(String[] args) {
        Node root = Main.getTree();
        printNodesAtKDistance(root,0);
        System.out.println();
        printNodesAtKDistance(root,1);
        System.out.println();
        printNodesAtKDistance(root,2);
    }
    public static void printNodesAtKDistance(Node root,int k){ //TC : O(N) SC : (height)
        if (root==null)return;
        if (k==0){
            System.out.print(root.data+" ");
            return;
        }
        printNodesAtKDistance(root.left,k-1);
        printNodesAtKDistance(root.right,k-1);
    }
}
