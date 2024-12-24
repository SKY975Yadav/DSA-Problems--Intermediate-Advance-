import javax.swing.*;

public class OperationUsingTail {
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
//        Main.traverse(head);
        tail = insertAtEnd(tail,40);
        tail = insertAtEnd(tail,45);
//        tail = insertAtEnd(tail,89);
        Main.DTraverse(head);
        search(head,tail,30);
//        reverseTraverse(tail);
//        tail = deleteAtEnd(tail);
//        Main.traverse(head);
//        System.out.println(head.data);
//        System.out.println(tail.data);
    }
    //At O(1) time
    public static DNode insertAtEnd(DNode tail,int x){
        DNode temp = new DNode(x);
        tail.next=temp;
        temp.prev = tail;
        return temp;
    }
    //The best solution for delete at end this is the best and easiest method to delete at end
    private static DNode deleteAtEnd(DNode tail){
        if (tail == null || tail.prev==null) return null;
        DNode cur = tail.prev;
        tail.prev=null;
        cur.next=null;
        return cur;
    }
    public static void reverseTraverse(DNode tail){
        DNode cur = tail;
        while (cur!=null){
            System.out.print(cur.data+" ");
            cur = cur.prev;
        }
        System.out.println();
    }
    private static void search(DNode head,DNode tail,int x){
        if (head==null) return ;
        DNode start = head;
        DNode last= tail;
        int pos = 1;
        while (start!=last) {
            if (start.data == x || last.data == x) {
                if (start.data == x)
                    System.out.println(pos + " Position From the start");
                else System.out.println(pos + " Position From end");
                return;
            }
            start = start.next;
            last = last.prev;
            pos++;
            if (start.next==last.prev){
                if (start.next.data==x) {
                    pos++;
                    System.out.println(pos + " Position, Element found at the middle");
                    return;
                }
            }
        }
        System.out.println("Element not found");
    }
}
