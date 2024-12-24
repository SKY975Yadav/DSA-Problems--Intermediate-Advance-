public class ReverseLinkedListInGroupOfSizeK {
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

        Main.printLL(head);
        head = reverseLL(head,4);
        Main.printLL(head);
    }
    static Node reverseLL(Node head,int k){

        Node cur = head,prevGroupFirst = null;
        boolean isFirstGroup = true;

        while (cur != null){

            Node first = cur,prev = null;
            int count = 0;

            while (cur!= null && count<k){

                Node next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                count++;
            }
            if (isFirstGroup){
                head = prev;
                isFirstGroup = false;
            }
            else {
                prevGroupFirst.next = prev;
            }
            prevGroupFirst = first;


        }
        return head;
    }
}
