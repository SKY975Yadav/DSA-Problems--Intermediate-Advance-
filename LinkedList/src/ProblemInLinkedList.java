class AllProblems{
    //Problem 1 find the middle of the linked list
    //Naive Solution : Two traversal
//    public int middleOfTheLinkedList(Node head){
//        if (head==null) return -1;
//        Node cur = head;
//        int size=0;
//        while (cur!=null){
//            size++;
//            cur = cur.next;
//        }
//        int pos = (size/2) ;
//        cur = head;
//        for (int i = 0; i < pos; i++) {
//            cur = cur.next;
//        }
//        return cur.data;
//    }
    //Best Solution : One traversal
    public int middleOfTheLinkedList(Node head){
        if (head == null) return -1;
        if (head.next==null) return head.data;
        Node fast = head;
        Node slow = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }

    //Problem 2 find the element that is Nth from the end
//    Naive solution: Two traversal
//    public int ElementNthFromTheEnd(Node head,int n){
//        if (n==0) return -1;
//        Node cur = head;
//        int size=0;
//        while (cur!=null){
//            size++;
//            cur = cur.next;
//        }
//        if (n>size) return -1;
//        int pos = size-n+1;
//        cur = head;
//        for (int i=1;i<pos;i++){
//            cur=cur.next;
//        }
//        return cur.data;
//    }
    //Best Solution one linked list traversal and one n traversal
    public int ElementNthFromTheEnd(Node head,int n){
        Node first = head;
        if (n<=0) return -1;
        for (int i=0;i<n ;i++){
            if (first==null) return -1;
            first =first.next;
        }
        Node second = head;
        while (first!=null){
            first = first.next;
            second = second.next;
        }
        return second.data;
    }
    //Problem 3 : Reverse a linkedList using iterative approach:

    public Node reverseLinkedListUsingIteration(Node head){
        Node curr=head;
        Node prev=null;
        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public Node reverseLinkedListUsingRecursionMethod1(Node head){
        if(head==null||head.next==null)return head;
        Node rest_head= reverseLinkedListUsingRecursionMethod1(head.next);
        Node rest_tail=head.next;
        rest_tail.next=head;
        head.next=null;
        return rest_head;
    }
    public Node reverseLinkedListUsingRecursionMethod2(Node curr,Node prev){
        if(curr==null)return prev;
        Node next=curr.next;
        curr.next=prev;
        return reverseLinkedListUsingRecursionMethod2(next,curr);
    }

    //Problem 4 Remove duplicates
    public void removeDuplicates(Node head)
    {
        Node cur = head;
        while (cur!=null && cur.next!=null){
            if (cur.data==cur.next.data){
                cur.next = cur.next.next;
            }
            else cur = cur.next;
        }
    }
}
public class ProblemInLinkedList {
    public static void main(String[] args) {
        AllProblems ap = new AllProblems();
        Node head = null;
        head = insertAtEnd(head,10);
//        head = insertAtEnd(head,10);
        head = insertAtEnd(head,20);
        head = insertAtEnd(head,30);
//        head = insertAtEnd(head,30);
        head = insertAtEnd(head,40);
        head = insertAtEnd(head,50);
//        head = insertAtEnd(head,60);
        TraversingLinkedList.printList(head);
        //Problem 1
//        System.out.println(ap.middleOfTheLinkedList(head));
        //Problem 2
//        System.out.println(ap.ElementNthFromTheEnd(head,1));
        //problem 3
//        head = ap.reverseLinkedListUsingIteration(head);
//        head = ap.reverseLinkedListUsingRecursionMethod1(head);
//        head = ap.reverseLinkedListUsingRecursionMethod2(head,null);
        //Problem 4
//        ap.removeDuplicates(head);
        TraversingLinkedList.printList(head);
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
}
