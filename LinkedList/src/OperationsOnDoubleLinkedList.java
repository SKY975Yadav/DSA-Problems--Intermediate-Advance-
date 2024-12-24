public class OperationsOnDoubleLinkedList {
    public static void main(String[] args) {
        DNode head = new DNode(10);
//        head = null;
        DNode temp1 = new DNode(20);
        DNode temp2 = new DNode(30);
        head.next =temp1;
        temp1.prev = head;
        temp1.next =temp2;
        temp2.prev = temp1;
        head = insertAtBeg(head,5);
        head = insertAtEnd(head,60);
        Main.DTraverse(head);
//        head = deleteAtBeg(head);
//        head = deleteAtEnd(head);
//        head = insertAtK(head,2,2);
//        head = deleteAtK(head,0);
//        head = insertAtK(head,6,8);
//        head = reverseList(head);
        Main.DTraverse(head);
    }
    public static DNode insertAtBeg(DNode head,int x){
        DNode temp = new DNode(x);
        if (head == null) return temp;
        head.prev = temp;
        temp.next=head;
        return temp;
    }
    public static DNode insertAtEnd(DNode head,int x){
        DNode temp = new DNode(x);
        if (head == null) return temp;
        DNode cur = head;
        while (cur.next!=null){
            cur = cur.next;
        }
        cur.next = temp;
        temp.prev = cur;
        return head;
    }
    private static DNode deleteAtBeg(DNode head){
        if (head==null || head.next==null) return null;
        DNode cur = head.next;
        head.next=null;
        cur.prev = null;
        return cur;
    }
    private static DNode deleteAtEnd(DNode head){
        if (head == null || head.next==null) return null;
        DNode cur = head;
        while (cur.next.next!=null){
            cur=cur.next;
        }
        cur.next.prev=null;
        cur.next=null;
        return head;
    }
    void addDNode(DNode head, int pos, int data)
    {
        // Your code here
        DNode newDNode = new DNode(data);
        DNode cur = head;
        for(int i=0;i<pos && cur!=null;i++){
            cur = cur.next;
        }
        if(cur==null){
            return;
        }
        newDNode.next = cur.next;
        cur.next = newDNode;
        newDNode.prev = cur;
    }
    private static DNode insertAtK(DNode head,int k,int x){
        if (k==0) return head;
        DNode temp = new DNode(x);
        if(k==1){
            temp.next=head;
            head.prev = temp;
            return temp;
        }
        DNode cur = head;
        for (int i = 0; i <k-2 && cur.next!=null; i++) {//cur == null for 74 line
            cur = cur.next;
        }
        if (cur.next==null){//cur == null for 74 line
            return head;
        }

        temp.next=cur.next;
        cur.next=temp;
        //if you want to add in the next pos after all list com ex we have [1,2,3] if k=4 we can it yo [1,2,3,4] if you want to this just unlock below code and 65,68 line code
//        if (temp.next==null){
//            temp.prev = cur;
//            return head;
//        }
        temp.next.prev=temp;
        temp.prev = cur;
        return head;
    }
    public static DNode sortedInsert(DNode head, int x)
    {
        // add your code here
        DNode newDNode = new DNode(x);
        if(head == null){
            return newDNode;
        }
        if(newDNode.data<head.data){
            newDNode.next = head;
            head.prev = newDNode;
        }
        if(head.next==null){
            if(head.data>x){
                newDNode.next = head;
                head.prev = newDNode;
                return newDNode;
            }
            else{
                head.next=newDNode;
                newDNode.prev = head;
                return head;
            }
        }
        DNode cur = head;
        while(cur.next!=null && cur.data<=x){
            cur = cur.next;
        }
        if(cur.next==null && cur.data<=x){

            cur.next=newDNode;
            newDNode.prev = cur;
            return head;

        }
        newDNode.prev=cur.prev;
        newDNode.next = cur;
        cur.prev = newDNode;
        newDNode.prev.next = newDNode;
        return head;
    }
    private static DNode deleteAtK(DNode head,int k){
        if (k==0)return  head;
        if (head==null || (head.next==null && k==1)) return null;
        if (head.next==null) return head;
        if (k==1){
            DNode temp = head.next;
            temp.prev = null;
            head.next=null;
            return temp;
        }
        DNode cur = head;
        for (int i=0;i<k-2 && cur.next!=null;i++){
            cur = cur.next;
        }
        if (cur.next==null){
            return head;
        }
        if (cur.next.next==null){
            cur.next.prev=null;
            cur.next=null;
            return head;
        }
        DNode tem = cur.next;
        cur.next= tem.next;
        tem.next.prev = cur;
        return head;
    }
}
