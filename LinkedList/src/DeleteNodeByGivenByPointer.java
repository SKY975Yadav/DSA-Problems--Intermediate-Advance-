public class DeleteNodeByGivenByPointer {
    public static void main(String[] args) {

        Node head = new Node(10);
        Main.insert(head,20);
        Main.insert(head,30);
        Main.insert(head,40);
        Main.insert(head,50);
        Node temp = Main.insert(head,60);
        Main.insert(head,70);
        Main.insert(head,80);
        Main.insert(head,90);
        Main.insert(head,100);

        Main.printLL(head);
        deleteNodeInGivenPointer(temp);
        Main.printLL(head);

    }
    static void deleteNodeInGivenPointer(Node ptr){ // we cannot delete the last node so this algo work for 1 to n-1 nodes
        ptr.data = ptr.next.data;
        ptr.next = ptr.next.next;
    }
}
