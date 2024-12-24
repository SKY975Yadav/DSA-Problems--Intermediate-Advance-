import java.util.ArrayList;

class QueueUsingArrayList{
    private final ArrayList<Integer> queue = new ArrayList<>();
    private int size;
    boolean isEmpty(){
        return size==0;
    }
    int getFront(){
        if (isEmpty())
            return -1;
        return 0;
    }
    int getRear(){
        if (isEmpty())
            return -1;
        return size-1;
    }
    int getSize(){
        return size;
    }
    void enqueue(int x){
        queue.add(x);
        size++;
    }
    void dequeue(){
        if (isEmpty()){
            System.out.println("Queue is Empty");
            return;
        }
        queue.remove(0);
        size--;
    }
    void display(){
        if (isEmpty()){
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println(queue);
    }
}
public class ImplementationOfArrayList {
    public static void main(String[] args) {
        QueueUsingArrayList qua = new QueueUsingArrayList();
        qua.enqueue(10);
        qua.enqueue(20);
        qua.enqueue(30);
        qua.enqueue(40);
        qua.enqueue(50);
        System.out.println(qua.getSize());
        System.out.println(qua.getFront());
        System.out.println(qua.getRear());
        qua.display();
        qua.dequeue();
        qua.dequeue();
        qua.dequeue();
        qua.dequeue();
        qua.dequeue();
        qua.dequeue();
        System.out.println(qua.getSize());
        System.out.println(qua.getFront());
        System.out.println(qua.getRear());
        qua.display();
        for (int i=0;i<10;i++){
            qua.enqueue(60+(i*10));
        }
        qua.display();
        qua.dequeue();
        qua.display();
    }
}
