public class OperationsOnLinkedList {
    public static void main(String[] args) {
        //Search :
//        Node head = new Node(10);
//        head.next  = new Node(20);
//        head.next.next = new Node(30);
//        head.next.next.next = new Node(40);
//        System.out.println(search(head,10));
//        System.out.println(searchUsingRecursion(head,30));
        //Insert and delete at start and end
//        Node head = null;
//        head = insertAtEnd(head,10);
//        head = insertAtEnd(head,20);
//        head = insertAtBeginning(head,1);
//        head = insertAtEnd(head,30);
//        head = insertAtEnd(head,40);
//        head = insertAtEnd(head,50);
//        TraversingLinkedList.printList(head);
//        System.out.println();
//        head = deleteAtFirst(head);
//        head = deleteAtEnd(head);
//        TraversingLinkedList.printList(head);

        //Insert and delete at given position and element and sorted list
        Node head = null;
        head = insertAtEnd(head,10);
        head = insertAtEnd(head,20);
        head = insertAtEnd(head,30);
        head = insertAtEnd(head,40);
        head = insertAtEnd(head,50);
        head = insertAtEnd(head,20);
        TraversingLinkedList.printList(head);
        System.out.println();
//        head = insertAtGivenPosition(head,1,1);//insert at first
//        head = insertAtGivenPosition(head,5,35);//insert at middle pos
//        head = insertAtGivenPosition(head,7,48);//insert at last element pos
//        head = insertAtGivenPosition(head,9,89);//insert at end pos
//        head = insertAnElementInSortedList(head,5);//insert at beginning
//        head = insertAnElementInSortedList(head,25);//insert at middle
//        head = insertAnElementInSortedList(head,65);//insert at end
//        head = deleteAtGivenPosition(head,1);// at beg
//        head = deleteAtGivenPosition(head,2);// at middle
//        head = deleteAtGivenPosition(head,3);// at end
        head = deleteGivenElement(head,10);//at beg
        head = deleteGivenElement(head,20);//at middle
        head = deleteGivenElement(head,50);//at end

        TraversingLinkedList.printList(head);
    }
    private static int search(Node head,int x){
        Node current = head;
        int pos = 1;
        while (current != null){
            if (current.data == x){
                return pos;
            }
            pos++;
            current=current.next;
        }
        return -1;
    }
    private static int searchUsingRecursion(Node head,int x){
        if (head==null) return -1;
        if (head.data==x) return 1;
        int res = searchUsingRecursion(head.next,x);
        if (res==-1) return -1;
        return res+1;
    }
    private static Node insertAtBeginning(Node head,int x){
        Node temp = new Node(x);
        temp.next = head;
        return temp;
    }
    private static Node insertAtEnd(Node head, int x){
        if (head == null){
            return new Node(x);
        }
        Node temp = new Node(x);
        Node cur = head;
        while (cur.next!=null)
            cur = cur.next;
        cur.next = temp;
        return head;
    }
    private static Node deleteAtFirst(Node head){// or delete at head
        if (head == null) return null;
        return head.next;
    }
    private static Node deleteAtEnd(Node head){// or delete at tail
        if (head==null || head.next ==null){
            return null;
        }
        Node cur = head;
        while (cur.next.next != null){
            cur = cur.next;
        }
        cur.next =null;
        return head;
    }
    private static Node insertAtGivenPosition(Node head,int pos,int x){
        Node temp = new Node(x);
        if (pos == 1 ){
            temp.next = head;
            return temp;
        }
        Node cur = head;
        for (int i = 0; i <pos-2 && cur!=null; i++) {
            cur = cur.next;
        }
        if (cur==null){
            return head;
        }
        temp.next = cur.next;
        cur.next = temp;
        return head;
    }
    private static Node insertAnElementInSortedList(Node head,int key){
        Node temp = new Node(key);
        if (head == null){
            return temp;
        }
        if (key< head.data) {
            temp.next = head;
            return temp;
        }
        Node cur = head;
        while(cur.next!= null && cur.next.data<key){
            cur = cur.next;
        }
        temp.next=cur.next;
        cur.next = temp;
        return head;
    }
    private static Node deleteAtGivenPosition(Node head,int pos){
        if (head == null) return null;
        if (pos == 1) {
            return head.next;
        }
        Node cur = head;
        for (int i = 1; i <=pos-2 && cur.next!=null; i++) {
            cur = cur.next;
        }
        if (cur.next != null) {
            cur.next = cur.next.next;
        }
        return head;
    }
    //My code :
    private static Node deleteGivenElement(Node head,int x){
        if (head == null) return null;
        while (head != null && head.data == x) {//If we want to delete only one element ,instead of while loop we use simple if that check head.data == x then we return head.next
            head = head.next;
        }
        Node cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.data == x) {
                cur.next = cur.next.next; // Skip the node with data x
//                break; we use if only one element want to delete
            } else {
                cur = cur.next; // Move to the next node
            }
        }
        return head;
    }
}
