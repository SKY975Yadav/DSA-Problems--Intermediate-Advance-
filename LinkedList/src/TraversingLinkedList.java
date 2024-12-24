public class TraversingLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next  = new Node(20);
        head.next.next = new Node(30);
        Node tail = head.next.next.next = new Node(40);
        System.out.println(tail.data);
//        printList(head);
//        printListUsingRecursion(head);
    }
    public static void printList(Node head){//Using Iteration
        Node cur =head;
        while (cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
    private static void printListUsingRecursion(Node head){
        if (head == null)
            return;
        System.out.print(head.data+" ");
        printListUsingRecursion(head.next);
    }
}
