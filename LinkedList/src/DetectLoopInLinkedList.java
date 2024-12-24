import java.util.HashSet;

public class DetectLoopInLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp = head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = temp;

//        System.out.println(detectLoop(head));
//        System.out.println(detectLoopUsingHash(head));
        System.out.println(detectLoopUsingFloydCycleDetectionAlgo(head));
    }
    public static boolean detectLoop(Node head){ // Modify original linkedlist

        Node cur = head;
        Node dammy = new Node(-1);
        while (cur!=null){
            if (cur.next==dammy){
                return true;
            }
            Node temp = cur.next;
            cur.next = dammy;
            cur = temp;
        }
        return false;
    }

    public static boolean detectLoopUsingHash(Node head){ // O(n) AS
        HashSet<Node> hs =new HashSet<>();

        Node cur = head;

        while (cur!=null){
            if (hs.contains(cur)){
                return true;
            }
            hs.add(cur);
            cur = cur.next;
        }
        return false;
    }

    public static boolean detectLoopUsingFloydCycleDetectionAlgo(Node head){

        Node slow = head,fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }
}