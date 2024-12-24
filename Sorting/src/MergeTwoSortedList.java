public class MergeTwoSortedList {
    public static void main(String[] args) {
        Node head1 = new Node(18);
        Main.insert(head1,20);
        Main.insert(head1,30);
        Main.insert(head1,40);
        Main.insert(head1,50);
        Node head2 = new Node(10);
        Main.insert(head2,10);
        Main.insert(head2,30);
        Main.insert(head2,32);
        Main.insert(head2,45);
        Main.insert(head2,45);

        Node mergeList = merge(head2,head1);
//        Node mergeList = sortedMerge(head1,head2);
        Main.printLL(mergeList);
    }
    static Node merge(Node head1,Node head2){ // Method 1 my implementation

        if (head1 == null ) return head2;
        else if (head2 == null) return head1;

        Node cur1 = head1,cur2 = head2,prev = null;

        while (cur1 != null){

            if (cur1.data <= cur2.data){
                prev = cur1;
                cur1 = cur1.next;
            }
            else {
                Node temp = cur2;
                cur2 = cur2.next;
                if (cur1 == head1){
                    temp.next = cur1;
                    prev = head1 = temp;
                }
                else {
                    temp.next = cur1;
                    prev.next = temp;
                    prev = temp;
                }
            }
            if (cur2==null){
                break;
            }
        }
        if (cur1 == null){
            prev.next = cur2;
        }
        return head1;
    }
    static Node sortedMerge(Node a,Node b){ // Method 2 Most popular
        if(a==null)return b;
        if(b==null)return a;
        Node head,tail;
        if(a.data<=b.data){
            head=tail=a;
            a=a.next;
        }
        else{
            head=tail=b;
            b=b.next;
        }
        while(a!=null&&b!=null){
            if(a.data<=b.data){
                tail.next=a;tail=a;a=a.next;
            }
            else{
                tail.next=b;tail=b;b=b.next;
            }
        }
        if(a==null){tail.next=b;}
        else{
            tail.next=a;
        }
        return head;
    }
}
