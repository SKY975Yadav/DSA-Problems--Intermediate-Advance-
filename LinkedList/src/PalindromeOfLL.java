public class PalindromeOfLL {
    public static void main(String[] args) {
        Node head = new Node(10);
        Main.insert(head,20);
        Main.insert(head,30);
        Main.insert(head,40);
        Main.insert(head,50);
        Main.insert(head,40);
        Main.insert(head,30);
        Main.insert(head,20);
        Main.insert(head,10);
        System.out.println(isPalindrome(head));
        Main.printLL(head);
    }
    static boolean isPalindrome(Node head){

        if (head == null || head.next == null) return true;
        //Find the middle Node
        Node slow = head,fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse 2nd half of linkedList
        Node cur = slow.next;
        Node prev = null;
        while (cur != null){
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
//        Node secCur = reverseAndClone(slow.next); // If we doesn't want to change our original LL
            //Traverse from start and second half compare each element is it same or not

        slow.next = prev;
        Node secCur = prev;
        cur = head;
        while (secCur != null){
            if (cur.data != secCur.data){
                return false;
            }
            secCur = secCur.next;
            cur = cur.next;
        }
        return true;
    }

    static Node reverseAndClone(Node node) {
        Node prev = null;
        while (node != null) {
            Node newNode = new Node(node.data); // Clone the node
            newNode.next = prev;
            prev = newNode;
            node = node.next;
        }
        return prev; // Return the head of the reversed list
    }
}
