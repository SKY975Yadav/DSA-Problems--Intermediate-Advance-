public class CircularDoublyLinkedList {
    public static void main(String[] args) {
        DNode head = new DNode(10);
//        head.next=head;
//        head.prev=head;
////        head = null;
        DNode temp1 = new DNode(20);
        DNode temp2 = new DNode(30);
        head.next =temp1;
        temp1.prev = head;
        temp1.next =temp2;
        temp2.prev = temp1;
        head.prev = temp2;
        temp2.next=head;
//        traverse(head);
        System.out.println(isCircular(head));
//        head = insertAtBeg(head,5);
//        head = insertAtEnd(head,60);
//        traverse(head);
    }
    public static void traverse(DNode head){
        if (head == null) return;
        DNode cur = head;
        do {
            System.out.print(cur.data+" ");
            cur =cur.next;
        }while (cur!=head);
        System.out.println();
    }
    public static boolean compareCLL(DNode head1, DNode head2) {
        // Your code here
        if (head1 == null || head2 == null){
            return false;
        }
        DNode cur1 = head1;
        DNode cur2 = head2;
        do{
            if(cur1.data != cur2.data){
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }while(cur1 != head1 || cur2!= head1);
        return true;
    }
    public static boolean isCircular(DNode head)
    {
        // your code here
        if(head == null || head.next==null) return false;
        if (head.next==head && head.prev==head){
            return true;
        }
        DNode cur = head;
        DNode prev = head;
        do{
            if(cur.next==null || prev.prev==null){
                return false;
            }
            cur = cur.next;
            prev = cur.prev;
        }while(cur.next!=head || prev.prev != head);
        return true;
    }
    private static DNode insertAtBeg(DNode head,int x){
        DNode newDNode = new DNode(x);
        if (head==null){
            newDNode.next=newDNode;
            newDNode.prev = newDNode;
            return newDNode;
        }
        DNode tail = head.prev;
        newDNode.next=head;
        head.prev=newDNode;
        tail.next=newDNode;
        newDNode.prev=tail;
        return newDNode;
    }
    private static DNode insertAtEnd(DNode head,int x){
        DNode newDNode = new DNode(x);
        if (head==null){
            newDNode.next=newDNode;
            newDNode.prev = newDNode;
            return newDNode;
        }
        DNode tail = head.prev;
        head.prev = newDNode;
        tail.next =newDNode;
        newDNode.next=head;
        newDNode.prev=tail;
        return head;
    }
}
