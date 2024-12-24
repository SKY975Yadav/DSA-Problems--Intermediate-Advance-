import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueue1<T>{ // Using Two Queues modifying push opn

    private Queue<T> q1 = new LinkedList<>();
    private Queue<T> q2 = new LinkedList<>();
    static int cur_size ;
    StackUsingQueue1(){
        cur_size = 0;
    }

    public void push(T data){
        q2.offer(data);

        cur_size++;

        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        Queue<T> q = q1;
        q1 = q2;
        q2 = q;
    }
    public T pop(){
        if (q1.isEmpty()) return null;
        cur_size--;
        return q1.poll();

    }
    public T top(){
        if (q1.isEmpty()) return null;
        cur_size--;
        return q1.peek();
    }
    public int size(){
        return cur_size;
    }

    @Override
    public String toString() {
        return q1.toString();
    }
}


class StackUsingQueue2<T>{ // Using Two Queues modifying pop and top opn

    private Queue<T> q1 = new LinkedList<>();
    private Queue<T> q2 = new LinkedList<>();
    static int cur_size ;
    StackUsingQueue2(){
        cur_size = 0;
    }

    public void push(T data){
        q1.offer(data);
        cur_size++;
    }
    public T pop(){
        if (q1.isEmpty()) return null;
        while (q1.size()>1){
            q2.offer(q1.poll());
        }
        T data = q1.poll();
        q1 = q2;
        q2 = new LinkedList<>();
        return data;
    }
    public T top(){
        if (q1.isEmpty()) return null;
        T data = q1.peek();
        while (!q1.isEmpty()){
            q2.offer(data = q1.poll());
        }
        q1 = q2;
        q2 = new LinkedList<>();
        return data;
    }
    public int size(){
        return cur_size;
    }

    public String toString() {
        return q1.toString();
    }
}

class StackUsingQueue3<T>{ // Using One Queue modifying pop and top opn

    private final Queue<T> q1 = new LinkedList<>();
    static int cur_size ;
    StackUsingQueue3(){
        cur_size = 0;
    }

    public void push(T data){
        q1.offer(data);
        cur_size++;
    }
    public T pop(){
        if (q1.isEmpty()) return null;
        reverseQueue(q1);
        T data = q1.poll();
        reverseQueue(q1);
        return data;
    }
    private static <T> void  reverseQueue(Queue<T> queue){
        if (queue.isEmpty()) return;
        T data = queue.poll();
        reverseQueue(queue);
        queue.offer(data);
    }
    public T top(){
        if (q1.isEmpty()) return null;
        reverseQueue(q1);
        T data = q1.peek();
        reverseQueue(q1);
        return data;
    }
    public int size(){
        return cur_size;
    }

    public String toString() {
        return q1.toString();
    }
}

class StackUsingQueue4<T>{ // Using Two Queues modifying push opn

    private final Queue<T> q1 = new LinkedList<>();
    static int cur_size ;
    StackUsingQueue4(){
        cur_size = 0;
    }

    public void push(T data){
        reverseQueue(q1);
        q1.offer(data);
        reverseQueue(q1);
    }
    static <T> void  reverseQueue(Queue<T> queue){
        if (queue.isEmpty()) return;
        T data = queue.poll();
        reverseQueue(queue);
        queue.offer(data);
    }
    public T pop(){
        if (q1.isEmpty()) return null;
        cur_size--;
        return q1.poll();

    }
    public T top(){
        if (q1.isEmpty()) return null;
        cur_size--;
        return q1.peek();
    }
    public int size(){
        return cur_size;
    }

    @Override
    public String toString() {
        return q1.toString();
    }
}
public class ImplementationOfStackUsingQueueDS {
    public static void main(String[] args) {
//        StackUsingQueue1<Integer> stack = new StackUsingQueue1<>();
//        stack.push(34);
//        stack.push(44);
//        stack.push(54);
//        stack.push(14);
//        stack.push(24);
//        System.out.println(stack);
//        System.out.println(stack.pop());
//        System.out.println(stack.top());
//        System.out.println(stack);


//        StackUsingQueue2<String> st = new StackUsingQueue2<>();
//        st.push("sai");
//        st.push("krishna");
//        st.push("yadav");
//        st.push("villain");
//        st.push("time");
//        System.out.println(st);
//        System.out.println(st.top());
//        System.out.println(st.pop());
//        System.out.println(st);
//        st.push("plant");
//        System.out.println(st);
//        System.out.println(st.pop());
//        System.out.println(st);


//        StackUsingQueue3<String> st = new StackUsingQueue3<>();
//        st.push("sai");
//        st.push("krishna");
//        st.push("yadav");
//        st.push("villain");
//        st.push("time");
//        System.out.println(st);
//        System.out.println(st.top());
//        System.out.println(st.pop());
//        System.out.println(st);
//        st.push("plant");
//        System.out.println(st);
//        System.out.println(st.pop());
//        System.out.println(st);

        StackUsingQueue4<String> st = new StackUsingQueue4<>();
        st.push("sai");
        st.push("krishna");
        st.push("yadav");
        st.push("villain");
        st.push("time");
        System.out.println(st);
        System.out.println(st.top());
        System.out.println(st.pop());
        System.out.println(st);
        st.push("plant");
        System.out.println(st);
        System.out.println(st.pop());
        System.out.println(st);
    }
}
