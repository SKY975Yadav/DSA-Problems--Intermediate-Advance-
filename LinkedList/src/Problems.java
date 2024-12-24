//Sum of doubly linked list in O(n/2)

public class Problems {
    public static void main(String[] args) {
        DNode head = new DNode(10);
//        head = null;
        DNode temp1 = new DNode(20);
        DNode temp2 = new DNode(30);
        head.next =temp1;
        temp1.prev = head;
        temp1.next =temp2;
        temp2.prev = temp1;
        DNode tail = temp2;
        tail = OperationUsingTail.insertAtEnd(tail,40);
        tail = OperationUsingTail.insertAtEnd(tail,45);
        tail = OperationUsingTail.insertAtEnd(tail,55);
        Main.DTraverse(head);
        System.out.println(sumOfLinkedList(head,tail));
    }
    public static int sumOfLinkedList(DNode head,DNode tail){
        if (head==null) return -1;
        int sum = 0;
        if (head==tail) return head.data;
        DNode start = head;
        DNode last = tail;
        while (start!=last){
            sum += start.data+ last.data;
            start = start.next;
            last = last.prev;
            if (start.next==last || start.next== last.prev){
                if (start.next==last.prev){
                    sum += start.data+last.data;
                }
                if (start.next==last)
                    sum += start.data;
                System.out.println(start.data);
                System.out.println(last.data);
                System.out.println("Dsf");
                sum += start.next.data;
                break;
            }
        }
        return sum;
    }
}
