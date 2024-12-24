import java.util.logging.Handler;

public class PairWiseSwap {
    public static void main(String[] args) {
        Node head = new Node(10);
        Main.insert(head,20);
        Main.insert(head,30);
        Main.insert(head,40);
        Main.insert(head,50);
        Main.insert(head,60);
        Main.insert(head,70);
        Main.insert(head,80);
        Main.insert(head,90);
        Main.insert(head,100);

//        Main.printLL(head);
//        pairWiseSwap(head);
//        Main.printLL(head);

        Main.printLL(head);
        head = pairWiseSwapEfficient(head);
        Main.printLL(head);

    }
    static void pairWiseSwap(Node head){  //Swap the data
        if (head == null || head.next == null) return;

        Node cur = head;

        while (cur != null && cur.next != null) {
            // Swap data of current node and next node
            int temp = cur.data;
            cur.data = cur.next.data;
            cur.next.data = temp;

            // Move to the next pair
            cur = cur.next.next;
        }
    }
    static Node pairWiseSwapEfficient(Node head){ // Swap the links or references
        if (head == null || head.next==null) return head;

        Node cur = head.next.next;
        Node prev = head;
        head = head.next;
        head.next = prev;

        while (cur !=null && cur.next != null){
            prev.next = cur.next;
            Node next = cur.next.next;
            cur.next.next = cur;
            prev = cur;
            cur = next;
        }
        prev.next = cur;
        return head;
    }
}
