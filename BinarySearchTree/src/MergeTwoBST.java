import java.util.*;

public class MergeTwoBST {
    public static void main(String[] args) {
        Node root1 = Main.getTree();
        BinarySearchTree bst = new BinarySearchTree();
        Node root2 = bst.getRoot(30);
        root2 = bst.insert(root2,34);
        root2 = bst.insert(root2,20);
        root2 = bst.insert(root2,19);
        root2 = bst.insert(root2,32);
        root2 = bst.insert(root2,19);
        root2 = bst.insert(root2,20);
        System.out.println(merge(root1,root2));
    }

    public static List<Integer> merge(Node root1, Node root2) {
        // Write your code here
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inorderTraversal(root1, list1);
        inorderTraversal(root2, list2);
        return mergeTwoLists(list1, list2);
    }

    private static void inorderTraversal(Node root, List<Integer> al) {
        if (root == null) return;
        inorderTraversal(root.left, al);
        al.add(root.data);
        inorderTraversal(root.right, al);
    }

    private static List<Integer> mergeTwoLists(List<Integer> li1, List<Integer> li2) {
        int n1 = li1.size(), n2 = li2.size();
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (li1.get(i) <= li2.get(j)){
                res.add(li1.get(i++));
            }
            else{
                res.add(li2.get(j++));
            }
        }
        while (i < n1){res.add(li1.get(i++));}
        while (j < n2){res.add(li2.get(j++));}
        return res;
    }
}
