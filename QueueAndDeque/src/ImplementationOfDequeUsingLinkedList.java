class Node{
    int data;
    Node next,prev;
    Node(int x){
        this.data = x;
        next=null;
        prev=null;
    }
}
class DequeUsingLinkedList{
    private int size = 0;
    private Node front,rear;
    int getSize(){
        return size;
    }
    boolean isEmpty(){
        return front==null;
    }
    void insertAtFront(int x){
        Node temp = new Node(x);
        if (front==null) {
            front =rear= temp;
            size++;
            return;
        }
        temp.next = front;
        front.prev = temp;
        front = temp;
        size++;
    }
    void deleteAtFront(){
        if (front==null){
            System.out.println("Deque is empty");
            return;
        }
        if (front.next==null){
            front = rear = null;
            size--;
            return;
        }
        front.next.prev = null;
        front = front.next;
        size--;
    }
    void insertAtRear(int x){
        Node temp = new Node(x);
        if (rear==null){
            front = rear = temp;
            size++;
        }
        rear.next=temp;
        temp.prev = rear;
        rear = temp;
        size++;
    }
    void deleteAtRear(){
        if (rear==null){
            System.out.println("Deque is empty");
            return;
        }
        if(rear.prev==null){
            front=rear=null;
            size--;
            return;
        }
        rear.prev.next=null;
        rear=rear.prev;
        size--;
    }
    int getFront(){
        if (front==null){
            System.out.println("Deque is Empty");
            return -1;
        }
        return front.data;
    }
    int getRear(){
        if (rear==null){
            System.out.println("Deque is Empty");
            return -1;
        }
        return rear.data;
    }
    void display(){
        if (front==null){
            System.out.println("Deque is empty");
            return;
        }
        Node cur = front;
        while (cur!=null){
            System.out.print(cur.data+" ");
            cur =cur.next;
        }
        System.out.println();
    }
}
public class ImplementationOfDequeUsingLinkedList {
    public static void main(String[] args) {
        DequeUsingLinkedList dql = new DequeUsingLinkedList();
//        dql.insertAtFront(10);
//        dql.insertAtFront(20);
//        dql.insertAtFront(30);
//        dql.insertAtFront(40);
//        dql.insertAtFront(50);
//        System.out.println(dql.getFront());
//        System.out.println(dql.getRear());
//        System.out.println(dql.getSize());
        //For Queue :
//        dql.deleteAtRear();
//        dql.deleteAtRear();
//        dql.display();
//        dql.display();
//        dql.deleteAtRear();
//        dql.display();
//        System.out.println(dql.getFront());
//        System.out.println(dql.getRear());
//        System.out.println(dql.getSize());
        dql.insertAtRear(10);
        dql.insertAtRear(20);
        dql.insertAtRear(30);
        dql.insertAtRear(40);
        dql.insertAtRear(50);
        dql.display();
//        dql.deleteAtFront();
//        dql.deleteAtFront();

        dql.deleteAtRear();
        dql.deleteAtRear();
        dql.display();
//        dql.deleteAtRear();
//        dql.deleteAtRear();
//        dql.display();
//        dql.deleteAtFront();
//        dql.deleteAtFront();
//        dql.display();
        //For Stack
//        dql.deleteAtFront();
//        dql.deleteAtFront();
//        dql.deleteAtFront();
    }
}
