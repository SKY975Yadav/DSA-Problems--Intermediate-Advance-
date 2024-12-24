import com.sun.source.tree.BinaryTree;

public class ConvertBinaryTreeIntoDoublyLinkedList {
    public static void main(String[] args) {
        Node root = Main.getTree();
        BinaryTreeTraversal.inOrderTraversal(root);
        System.out.println();
        Node head = convertBT_to_DLL(root);
        printlist(head);
        System.out.println();

    }
    static Node prev = null;
    public static Node convertBT_to_DLL(Node root) {
        if(root==null)return null;

        Node head=convertBT_to_DLL(root.left);
        if(prev==null){head=root;}
        else{
            root.left=prev;
            prev.right=root;
        }
        prev=root;
        convertBT_to_DLL(root.right);
        return head;
    }
    public static void printlist(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.right;
        }
    }
}
