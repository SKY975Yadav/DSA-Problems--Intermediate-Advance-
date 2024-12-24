public class SortLinkedList {
    public static void main(String[] args) {

    }

    public Node  sortList(Node  head) {
        // Base case: if head is null or there is only one element
        if (head == null || head.next == null) {
            return head;
        }

        // Split the list into two halves
        Node  mid = getMiddle(head);
        Node  left = head;
        Node  right = mid.next;
        mid.next = null;

        // Recursively sort each half
        left = sortList(left);
        right = sortList(right);

        // Merge the sorted halves
        return merge(left, right);
    }

    // Function to get the middle of the linked list
    private Node  getMiddle(Node  head) {
        if (head == null) {
            return head;
        }

        Node  slow = head;
        Node  fast = head.next;

        // Move fast by two and slow by one
        // Finally slow will point to middle node
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Function to merge two sorted linked lists
    private Node  merge(Node  left, Node  right) {
        Node  dummy = new Node (0);
        Node  tail = dummy;

        while (left != null && right != null) {
            if (left.data <= right.data) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        // Append the remaining nodes of left or right
        if (left != null) {
            tail.next = left;
        } else {
            tail.next = right;
        }

        return dummy.next;
    }

}
