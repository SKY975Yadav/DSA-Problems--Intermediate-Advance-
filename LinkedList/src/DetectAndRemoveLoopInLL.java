public class DetectAndRemoveLoopInLL {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp = head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = temp;
//        Main.printLL(head);
        detectAndRemoveLoop(head);
        Main.printLL(head);

    }
    public static void detectAndRemoveLoop(Node head){

        Node slow = head,fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        if (slow != fast) return;

//        If we want to know the no.of element in the loop , we place slow at the same position and move fast ,
//        we make fast = fast.next then run a while loop while fast != slow . and count no.of elements
        slow = head;
        while (slow.next != fast.next){
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
        //If we want the first node of the loop we can get it by slow.next
    }
}
