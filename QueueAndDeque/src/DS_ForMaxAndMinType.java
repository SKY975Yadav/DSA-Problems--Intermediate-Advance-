import java.util.Deque;
import java.util.LinkedList;

class MaxAndMin<T>{
    private final Deque<T> deque = new LinkedList<>();

    T getMin(){
        if (deque.isEmpty())
            return null;
        return deque.getFirst();

    }
    T getMax(){
        if (deque.isEmpty())
            return null;
        return deque.getLast();
    }
    boolean setMin(T data){
        if (!deque.isEmpty() && (Integer) data >= (Integer)getMin()){
            return false;
        }
        deque.offerFirst(data);
        return true;
    }
    boolean setMax(T data){
        if (!deque.isEmpty() && (Integer) data <= (Integer)getMax()){
            return false;
        }
        deque.offerLast(data);
        return true;
    }

    T extractMin(){
        if (deque.isEmpty()) return null;
        return deque.removeFirst();
    }
    T extractMax(){
        if (deque.isEmpty()) return null;
        return deque.removeLast();
    }


}


public class DS_ForMaxAndMinType {
    public static void main(String[] args) {
        /*
        The video talks about designing a data structure that supports the following operations in O(1) time.

1) Get Minimum

2) Get Maximum

3) Insert Minimum

4) Insert Maximum

5) Delete Minimum

6) Delete Maximum

         */

        MaxAndMin<Integer> mam = new MaxAndMin<>();
        mam.setMin(100);
        mam.setMin(50);
        mam.setMin(20);
        mam.setMax(140);
        mam.setMax(160);
        System.out.println(mam.setMax(102));
        System.out.println(mam.getMax());
        System.out.println(mam.getMin());
        System.out.println(mam.extractMax());
        System.out.println(mam.extractMin());
        System.out.println(mam.getMin());
        System.out.println(mam.getMax());

    }
}
