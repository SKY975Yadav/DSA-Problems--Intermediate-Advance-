public class CreatingCloneOfLinkedList {
    public static void main(String[] args) {
        TwoLinksNode head = new TwoLinksNode(10,null,null);
        TwoLinksNode secondNode = Main.insertInTwoLinksNode(head,5);
        TwoLinksNode thirdNode = Main.insertInTwoLinksNode(head,20);
        TwoLinksNode fourthNode = Main.insertInTwoLinksNode(head,15);
        TwoLinksNode firthNode = Main.insertInTwoLinksNode(head,20);

        head.random = thirdNode;
        secondNode.random = fourthNode;
        thirdNode.random = head;
        fourthNode.random = thirdNode;
        firthNode.random = fourthNode;

        TwoLinksNode cloneHead  = createCloneOfLL(head);
        Main.printTwoDLL(head);
        Main.printTwoDLL(cloneHead);

    }
     static TwoLinksNode createCloneOfLL(TwoLinksNode head){

        if (head == null ) return null;
        TwoLinksNode cur = head;

        while(cur != null ){
            TwoLinksNode next = cur.next;
            cur.next = new TwoLinksNode(cur.data,next,null);
            cur = next;
        }

        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next; // Move to the next original node
        }

        cur = head;
        TwoLinksNode cloneHead = head.next;
        while (cur!=null){
            TwoLinksNode clone  = cur.next;
            cur.next = clone.next;
            if (clone.next != null){
                clone.next = clone.next.next;
            }
            cur = cur.next;
        }
        return cloneHead;
    }
}
