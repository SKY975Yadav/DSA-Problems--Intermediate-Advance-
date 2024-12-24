import java.util.ArrayList;

public class LCA_of_BinaryTree { // Lowest Common ancestor
    public static void main(String[] args) {
        Node root = Main.getTree();
        root.left.right.left = new Node(21);
        Node temp1 = lcaOfBtInOneTraversal(root,21,80);
        Node temp2 = lcaOfBtInTwoTraversal(root,21,80);
        System.out.println(temp1.data);
        System.out.println(temp2.data);
    }
    public static Node lcaOfBtInTwoTraversal(Node root,int n1,int n2){
        if (root == null) return null;

        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        if (!findPath(root,path1,n1) || !findPath(root,path2,n2)){
            return null;
        }

        for (int i=0;i<path1.size()-1 && i < path2.size()-1 ; i++){
            if (path1.get(i+1) != path2.get(i+1))
                return path1.get(i);
        }
        return null;
    }
    private static boolean findPath(Node root, ArrayList<Node> al,int n){ // Helper function for above code
        if (root== null) return false;
        al.add(root);
        if (root.data == n) return true;
        if (findPath(root.left,al,n) || findPath(root.right,al,n)) return true;
        al.remove(al.size()-1);
        return false;
    }
    public static Node lcaOfBtInOneTraversal(Node root,int n1,int n2){
        /*
        It assume that there is always two nodes present in the tree then only it  gives the correct ans else it return wrong answer
         */

        if (root == null) return null;
        if (root.data == n1 || root.data == n2) return root;
        Node lca1 = lcaOfBtInOneTraversal(root.left,n1,n2);
        Node lca2 = lcaOfBtInOneTraversal(root.right,n1,n2);
        if ( lca1 != null && lca2 != null){
            return root;
        }
        if (lca1 != null){
            return lca1;
        }else { // means lca2 != null
            return lca2;
        }
    }
}
