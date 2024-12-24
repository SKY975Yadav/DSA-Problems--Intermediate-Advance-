
class QueueUsingLinkedList{
    static class Node{
        int data;
        Node next;
        Node(int x){
            this.data = x;
            next = null;
        }
    }
    private Node front,rear;
    private int size;
    QueueUsingLinkedList(){
        front=null;
        rear = null;
        size = 0;
    }
    void enqueue(int x){
        Node temp = new Node(x);
        if (front==null){
            front = rear = temp;
            size++;
            return;
        }
        rear.next = temp;
        rear = temp;
        size++;
    }
    void dequeue(){
        if (front == null){
            System.out.println("Queue is Empty");
            return;
        }
        front = front.next;
        if (front == null) {
            rear = null;
            size=0;
            return;
        }
        size--;
    }
    boolean isEmpty(){
        return size==0;
    }
    int getFront(){
        if (isEmpty()){
            return -1;
        }
        return front.data;
    }
    int getRear(){
        if (isEmpty()){
            return -1;
        }
        return rear.data;
    }
    public int size() {
        return size;
    }
    public void display() {
        Node current = front;
        System.out.print("Queue elements: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class ImplementationOfQueueUsingLinkedList {
    public static void main(String[] args) {
        QueueUsingLinkedList qll = new QueueUsingLinkedList();
        qll.enqueue(10);
//        qll.enqueue(20);
//        qll.enqueue(30);
//        qll.enqueue(40);
//        qll.enqueue(50);
        qll.display();
        System.out.println(qll.size());
        System.out.println(qll.isEmpty());
        System.out.println(qll.getFront());
        System.out.println(qll.getRear());
        qll.dequeue();
//        qll.dequeue();
        qll.display();
        System.out.println(qll.size());
        System.out.println(qll.isEmpty());
        System.out.println(qll.getFront());
        System.out.println(qll.getRear());
    }
}
