class Node{
    int data;
    Node next;
    Node(int d){
        data =d;
        next = null;
    }
}
class StackUsingLL{
    Node head;
    private int size;
    void push(int x){
        Node temp = new Node(x);
        temp.next = head;
        head = temp;
        size++;
    }
    int pop(){
        if (head == null){
            System.out.print("Stack is Empty : ");
            return -1;
        }
        int res = head.data;
        head=head.next;
        size--;
        return res;
    }
    int size(){
        return size;
    }
    int peek(){
        if (head == null){
            System.out.print("Stack is empty : ");
            return -1;
        }
        return head.data;
    }
    boolean isEmpty(){
        return head==null;
    }
//    void display(){
//        if (head == null){
//            System.out.println("Stack is empty");
//            return;
//        }
//        Node cur = head;
//        while (cur!=null){
//            System.out.print(cur.data+" ");
//            cur = cur.next;
//        }
//        System.out.println();
//    }
}
public class ImplementationOfStackUsingLinkedList {
    public static void main(String[] args) {
        StackUsingLL sl = new StackUsingLL();
        sl.push(10);
        sl.push(30);
        sl.push(50);
        sl.push(70);
        System.out.println(sl.size());
        System.out.println(sl.isEmpty());
//        sl.display();
        System.out.println(sl.peek());
        System.out.println(sl.pop());
        System.out.println(sl.pop());
        System.out.println(sl.pop());
        System.out.println(sl.pop());
        System.out.println(sl.isEmpty());
//        sl.display();
    }
}
