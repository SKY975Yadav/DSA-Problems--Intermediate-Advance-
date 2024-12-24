public class SegregateEvenOddInLL {
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

    }
    static Node segregateEvenOdd(Node head){

        Node startOfEven = null,curEven = null,startOfOdd = null,curOdd = null;
        Node cur = head;
        while (cur != null){

            if (cur.data % 2 == 0){
                if (startOfEven == null){
                    startOfEven = cur;
                    curEven = cur;
                }
                else {
                    curEven.next = cur;
                    curEven = curEven.next;
                }
            }
            else {
                if (startOfOdd == null){
                    startOfOdd = cur;
                    curOdd = cur;
                }
                else {
                    curOdd.next = cur;
                    curOdd = curOdd.next;
                }
            }
            cur = cur.next;
        }
        if (startOfEven == null || startOfOdd == null){
            return head;
        }
        curEven.next = startOfOdd;
        curOdd.next = null;
        return startOfEven;
    }
}
