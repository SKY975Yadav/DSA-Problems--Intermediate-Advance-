import java.util.*;

public class Main {
    public static void main(String[] args) {
//        AVLTree tree = new AVLTree();
//        tree.insert(50);
//        tree.insert(12);
//        tree.insert(10);
//        tree.preOrder();
//
//        RedBlackTree tree1 = new RedBlackTree();
//        tree1.insert(34);
//        tree1.insert(22);
//        tree1.insert(62);
//        tree1.preOrder();
//
//        SplayTree tree2 = new SplayTree();
//        tree2.insert(345);
//        tree2.insert(23);
//        tree2.insert(234);
//        tree2.preOrder();

    }

   static Node getTree(){
        BinarySearchTree bst = new BinarySearchTree();
        Node root = bst.getRoot(50);
        bst.insert(root,30);
        bst.insert(root,10);
        bst.insert(root,35);
        bst.insert(root,75);
        bst.insert(root, 60);
        bst.insert(root,90);
        return root;
    }


}