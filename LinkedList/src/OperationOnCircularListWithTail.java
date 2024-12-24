public class OperationOnCircularListWithTail {
    public static void main(String[] args) {
        Node head = null;
        head = new Node(5);
        head.next= new Node(10);
        head.next.next = new Node(15);
        Node tail = head.next.next.next = new Node(20);
        tail.next= head;
        Main.circularTraverse(head);
        System.out.println(head.data);
        System.out.println(tail.data);
        head = insertAtBegin(tail,2);
        head = insertAtBegin(tail,1);
////        tail = insertAtEnd(head,tail,50);
//        tail = insertAtEnd(head,tail,70);
//        head = deleteAtBeg(tail);
        Main.circularTraverse(head);
        System.out.println(head.data);
        System.out.println(tail.data);
    }
    private static Node insertAtBegin(Node tail,int x){
        if (tail==null) return null;
        Node temp = new Node(x);
        temp.next = tail.next;
        tail.next = temp;
        return temp;
    }
    //Important insert At end is at O(1) time  this what it is different form linked list
    private static Node insertAtEnd(Node head,Node tail,int x){
        if (tail == null) return null;
        Node temp = new Node(x);
        temp.next = tail.next;
        tail.next = temp;
        return temp;
    }
    private static Node deleteAtBeg(Node tail){
        if (tail==null || tail.next==null) return null;
        tail.next=tail.next.next;
        return tail.next;
    }
}
