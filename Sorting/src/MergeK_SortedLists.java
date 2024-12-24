import java.util.PriorityQueue;

public class MergeK_SortedLists {
    public static void main(String[] args) {
        Node head1 = new Node(10);
        Main.insert(head1,20);
        Main.insert(head1,30);
        Main.insert(head1,40);
        Main.insert(head1,50);
        Node head3 = new Node(10);
        Main.insert(head3,16);
        Main.insert(head3,23);
        Main.insert(head3,35);
        Main.insert(head3,40);
        Main.insert(head3,50);

        Node head2 = new Node(25);
        Main.insert(head2,35);
        Main.insert(head2,45);
        Main.insert(head2,62);

        Node [] arr = {head1,head2,head3};
        Node res = mergeKList(arr, args.length);
        Main.printLL(res);
    }
    static Node mergeKList(Node[] lists,int K) // TC : O(n log k ) where n is the all the elements in all list combined and k is the no.of list SC : O(k)
    {
        //Add your code here.
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.data - b.data);

        // Add the heads of all K lists to the min-heap
        for (Node node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }

        Node dummy = new Node(0);
        Node tail = dummy;

        // While there are elements in the min-heap
        while (!minHeap.isEmpty()) {
            // Remove the smallest node from the min-heap
            Node smallest = minHeap.poll();
            tail.next = smallest;
            tail = tail.next;

            // Move to the next node in the list
            if (smallest.next != null) {
                minHeap.add(smallest.next);
            }
        }

        return dummy.next;

    }
}
