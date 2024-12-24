public class OperationOnCircularLinkedList {
    public static void main(String[] args) {
        Node head = null;
        head = new Node(5);
        head.next= new Node(10);
        head.next.next = new Node(15);
        head.next.next.next = new Node(20);
        head.next.next.next.next = head;
        Main.circularTraverse(head);

//        head = insertAtBegin(head,3);
//        head = insertAtBegin(head,2);

//        head = insertAtEnd(head,30);
//        head = insertAtEnd(head,50);

//        head = deleteAtBegin(head);
//        head = deleteAtBegin(head);

        traverseFromNode(head.next);
//        Main.traverse(head);
    }
    private static Node insertAtBegin(Node head,int x){
        Node temp =  new Node(x);
        if (head==null){
            temp.next= temp;
            return temp;
        }
        temp.next = head.next;
        head.next=temp;
        int t = head.data;
        head.data = temp.data;
        temp.data = t;
        return head;
    }
    private static Node insertAtEnd(Node head,int x){
        Node temp =  new Node(x);
        if (head==null){
            temp.next= temp;
            return temp;
        }
        temp.next = head.next;
        head.next=temp;
        int t = head.data;
        head.data = temp.data;
        temp.data = t;
        return temp;
    }
    private static Node deleteAtBegin(Node head){
        if (head == null) return null;
        if (head.next==head) return null;
        head.data = head.next.data;
        head.next = head.next.next;
        return head;
    }
    private static void traverseFromNode(Node node){
        if (node==null) return;
        Node cur = node;
        do {
            System.out.print(cur.data+" ");
            cur=cur.next;
        }while (cur!=node);
    }
}
