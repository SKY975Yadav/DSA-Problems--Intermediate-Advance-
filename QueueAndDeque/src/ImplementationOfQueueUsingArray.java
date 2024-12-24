import java.util.ArrayDeque;
import java.util.Deque;

class QueueUsingSimpleArray{
    private final int cap;
    private int size;
    private final int [] queue;
    QueueUsingSimpleArray(int c){
        cap =c;
        size = 0;
        queue = new int[cap];
    }
    boolean isFull(){
        return size==cap;
    }
    boolean isEmpty(){
        return size==0;
    }
    void enqueue(int x){
        if (isFull()) return;
        queue[size]=x;
        size++;
    }
    void dequeue(){
        if (isEmpty()) return;
        for (int i=0;i<size-1;i++){
//            System.out.println(queue[i]);
            queue[i]=queue[i+1];
        }
        size --;
    }
    int getFront(){
        if (isEmpty()) return -1;
        return 0;
    }
    int getRear(){
        if (isEmpty()) return -1;
        return size-1;
    }
    void display(){
        System.out.println();
        for (int i : queue){
//            if (i==0)return;
            System.out.print(i+" ");
        }
        System.out.println();
    }
}




class QueueUsingEfficientArray{
    private final int cap;
    private final int[] queue;
    private int front,size;
    QueueUsingEfficientArray(int x){
        cap = x;
         queue = new int[cap];
        front = 0;
        size = 0;
    }
    boolean isEmpty(){
        return size==0;
    }
    boolean isFull(){
        return cap==size;
    }
    int getFront(){
        if (isEmpty())
            return -1;
        return front;
    }
    int getRear(){
        if (isEmpty())
            return -1;
        return (front + size - 1) % cap;
    }
    void enqueue(int x){
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        int rear = getRear();
        rear =( rear+1) % cap;
        queue[rear] = x;
        size++;
    }
    int getSize(){
        return size;
    }
    void dequeue(){
        if (isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        front = (front+1)%cap;
        size--;
    }
    void display(){
        if (isEmpty())
            return;
        for (int i: queue){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
public class ImplementationOfQueueUsingArray {
    public static void main(String[] args) {
//        QueueUsingSimpleArray qsa = new QueueUsingSimpleArray(5);
//        qsa.enqueue(10);
//        qsa.enqueue(20);
//        qsa.display();
//        qsa.dequeue();
//        qsa.display();
//        qsa.enqueue(56);
//        qsa.display();
//        qsa.enqueue(58);
//        qsa.enqueue(78);
//        qsa.enqueue(90);
//        qsa.enqueue(299);
//        qsa.display();
//        qsa.dequeue();
//        qsa.display();
//        qsa.dequeue();
//        qsa.display();
//        System.out.println(qsa.getFront());
//        System.out.println(qsa.getRear());

        Deque<Integer> dt = new ArrayDeque<>(50);
        QueueUsingEfficientArray qea = new QueueUsingEfficientArray(5);
        qea.enqueue(10);
        qea.enqueue(20);
        qea.enqueue(30);
        qea.enqueue(40);
        qea.enqueue(50);
        qea.display();
        System.out.println("Front : " +qea.getFront());
        System.out.println("Rear : " +qea.getRear());
        System.out.println("Size : "+ qea.getSize());
        qea.dequeue();
        qea.display();
        System.out.println("Front : " +qea.getFront());
        System.out.println("Rear : " +qea.getRear());
        System.out.println("Size : "+ qea.getSize());
        qea.enqueue(60);
        qea.enqueue(80);
//        qea.dequeue();
        qea.display();
        System.out.println("Front : " +qea.getFront());
        System.out.println("Rear : " +qea.getRear());
        System.out.println("Size : "+ qea.getSize());


    }
}
