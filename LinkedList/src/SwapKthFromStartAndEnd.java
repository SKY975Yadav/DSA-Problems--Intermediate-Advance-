public class SwapKthFromStartAndEnd {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head = swapkthnode(head,2,2);
        Main.printLL(head);
    }
    static Node swapkthnode(Node head, int num, int k)
    {
        // your code here
        if(k>num) return head;
        if(head == null || head.next==null) return head;
        if (k==1 || num==k){
            Node cur = head;

            while(cur.next.next != null){
                cur = cur.next;
            }
            if (k==2){
                Node temp = head.next;
                temp.next = head;
                head.next = null;
                return temp;
            }
            Node temp = cur.next;
            temp.next = head.next;
            cur.next = head;
            head.next = null;
            head = temp;
            return head;
        }
        Node first = head,prevFirst = null;

        for(int i = 1 ; i < k; i++){
            prevFirst = first;
            first = first.next;
        }

        Node move = first.next;
        Node last = head,prevLast = null;

        while(move != null){
            move = move.next;
            prevLast = last;
            last = last.next;
        }

        Node temp = last.next;

        prevLast = first;
        prevFirst = last;
        last.next = first.next;
        first.next = temp;

        return head;

    }
}
