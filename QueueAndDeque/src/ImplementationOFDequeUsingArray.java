class DequeUsingSimpleArray{
    private int size;
    private final int cap;
    private final int [] ar;
    DequeUsingSimpleArray(int x){
        this.cap =x;
        ar = new int[cap];
        size =0;
    }
    boolean isEmpty(){
        return size==0;
    }
    boolean isFull(){
        return size==cap;
    }
    int size(){
        return size;
    }
    void insertAtRear(int x){
        if (isFull()){
            System.out.println("Deque is Full ");
            return;
        }
        ar[size] =x;
        size++;
    }
    void deleteAtRear(){
        if (isEmpty()) {
            System.out.println("Deque is Empty");
            return;
        }
        size--;
    }
    void insertAtFront(int x){
        if (isFull()){
            System.out.println("Deque is Full");
            return;
        }
        for (int i=size;i>0;i--){
            ar[i] = ar[i-1];
        }
        ar[0] = x;
        size++;
    }
    void deleteAtFront(){
        if (isEmpty()){
            System.out.println("Deque is Empty");
            return;
        }
        for (int i=0;i<size-1;i++){
            ar[i] = ar[i+1];
        }
        size--;
    }
    int getRear(){
        if (isEmpty()){
            System.out.println("Deque is Empty");
            return -1;
        }
        return size-1;//ar[size-1] for element
    }
    int getFront(){
        if (isEmpty()){
            System.out.println("Deque is Empty");
            return -1;
        }
        return 0;//ar[0] for element
    }
    void display(){
        if (isEmpty()){
            System.out.println("Deque is Empty");
            return;
        }
        for (int i=0;i<size;i++){
            System.out.print(ar[i]+" ");
        }
        System.out.println();
    }
}

class DequeUsingEfficientArray{
    private final int cap;
    private int size,front;
    private final int [] ar ;
    DequeUsingEfficientArray(int x){
        this.cap = x;
        size=0;
        front=0;
        ar = new int[cap];
    }
    boolean isEmpty(){
        return size==0;
    }
    boolean isFull(){
        return size==cap;
    }
    int size(){
        return size;
    }
    int getRear(){
        if (isEmpty()){
            System.out.println("Deque is Empty");
            return -1;
        }
        return (front+size-1)%cap;
    }
    int getFront(){
        if (isEmpty()){
            System.out.println("Deque is Empty");
            return -1;
        }
        return front;
    }
    void insertAtFront(int x){
        if (isFull()){
            System.out.println("Deque is Full");
            return;
        }
        front = (front-1+cap)%cap;
        ar[front] = x;
        size++;
    }
    void insertAtRear(int x){
        if (isFull()){
            System.out.println("Deque is Full");
            return;
        }
        int rear = (front+size)%cap;
        ar[rear] = x;
        size++;
    }
    void deleteAtFront(){
        if (isEmpty()){
            System.out.println("Deque is Empty");
            return;
        }
        front = (front+1)%cap;
        size--;
    }
    void deleteAtRear(){
        if (isEmpty()){
            System.out.println("Deque is Empty");
            return;
        }
        size--;
    }
    void display(){
        if (isEmpty()){
            System.out.println("Deque is Empty");
            return;
        }
        for (int i=0;i< cap;i++){
            System.out.print(ar[i]+" ");
        }
        System.out.println();
    }
}
public class ImplementationOFDequeUsingArray {
    public static void main(String[] args) {
        DequeUsingSimpleArray dsa = new DequeUsingSimpleArray(5);
//        dsa.insertAtFront(5);
//        dsa.insertAtFront(15);
//        dsa.insertAtFront(25);
//        dsa.insertAtFront(35);
//        dsa.insertAtFront(45);
//        dsa.display();
////        dsa.deleteAtFront();
////        dsa.deleteAtFront();
//        dsa.deleteAtRear();
//        dsa.display();
//        dsa.deleteAtRear();
//        dsa.display();
////        dsa.insertAtRear(10);
////        dsa.insertAtRear(20);
////        dsa.insertAtRear(30);
////        dsa.insertAtRear(40);
////        dsa.insertAtRear(50);
//        dsa.display();
////        System.out.println(dsa.isFull());
////        System.out.println(dsa.isEmpty());
////        System.out.println(dsa.size());
////        System.out.println(dsa.getFront());
////        System.out.println(dsa.getRear());
////        dsa.deleteAtRear();
////        dsa.deleteAtRear();
////        dsa.deleteAtRear();
//        dsa.deleteAtFront();
//        dsa.deleteAtFront();
//        dsa.deleteAtFront();
//        dsa.deleteAtFront();
//        dsa.deleteAtFront();
//        dsa.display();
////        System.out.println(dsa.isFull());
////        System.out.println(dsa.isEmpty());
////        System.out.println(dsa.size());
////        System.out.println(dsa.getFront());
////        System.out.println(dsa.getRear());
//        dsa.deleteAtFront();
//        dsa.deleteAtRear();

        DequeUsingEfficientArray dea = new DequeUsingEfficientArray(5);
        /*
        dea.insertAtFront(5);
        System.out.println("front :"+dea.getFront());
        System.out.println("Rear :"+dea.getRear());
        dea.insertAtFront(15);
        System.out.println("front :"+dea.getFront());
        System.out.println("Rear :"+dea.getRear());
        dea.insertAtFront(25);
        System.out.println("front :"+dea.getFront());
        System.out.println("Rear :"+dea.getRear());
        dea.insertAtFront(35);
        System.out.println("front :"+dea.getFront());
        System.out.println("Rear :"+dea.getRear());
        dea.insertAtFront(45);
        System.out.println("front :"+dea.getFront());
        System.out.println("Rear :"+dea.getRear());
//        dea.insertAtFront(70);
        System.out.println("size :"+dea.size());
        dea.display();
        dea.deleteAtFront();
        System.out.println("size :"+dea.size());
        System.out.println("front :"+dea.getFront());
        System.out.println("Rear :"+dea.getRear());
        dea.display();
        dea.insertAtFront(90);
        System.out.println("size :"+dea.size());
        System.out.println("front :"+dea.getFront());
        System.out.println("Rear :"+dea.getRear());
        dea.display();
        */
        dea.insertAtRear(23);
        dea.insertAtRear(33);
        dea.insertAtRear(63);
        dea.insertAtRear(73);
        dea.insertAtRear(93);
        System.out.println("size :"+dea.size());
        System.out.println("front :"+dea.getFront());
        System.out.println("Rear :"+dea.getRear());
        dea.display();
        dea.deleteAtFront();
        System.out.println("size :"+dea.size());
        System.out.println("front :"+dea.getFront());
        System.out.println("Rear :"+dea.getRear());
        dea.display();
        dea.insertAtFront(95);
        System.out.println("size :"+dea.size());
        System.out.println("front :"+dea.getFront());
        System.out.println("Rear :"+dea.getRear());
        dea.display();

    }
}
