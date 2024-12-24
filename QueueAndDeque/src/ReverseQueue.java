import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(13);
        q.offer(23);
        q.offer(33);
        q.offer(43);
        q.offer(53);
        System.out.println(q);
        System.out.println(q.peek());
        reverseQueue(q);
        System.out.println(q);
        System.out.println(q.peek());
    }
    static <T> void  reverseQueue(Queue<T> queue){
        if (queue.isEmpty()) return;
        T data = queue.poll();
        reverseQueue(queue);
        queue.offer(data);
    }
}
