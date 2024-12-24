import java.util.Stack;

class GetMinStack1 { // TC : O(1)  SC : O(n)

    Stack<Integer> ms;
    Stack<Integer> as;
    int size;
    GetMinStack1(){
        ms=new Stack<>();
        as=new Stack<>();
        size = 0;
    }

    void push(int x) {

        if(ms.isEmpty() ) {
            ms.add(x);as.add(x);return;
        }

        ms.add(x);
        size++;

        if(as.peek()>=ms.peek())
            as.add(x);
    }

    int pop() {
        if (size == 0){
            return Integer.MIN_VALUE;
        }
        if(as.peek()==ms.peek())
            as.pop();
        size--;
        return ms.pop();

    }

    int top() {
        return ms.peek();
    }

    int getMin() {
        return as.peek();
    }
    int getSize(){
        return size;
    }
}

class GetMinStack2{  //TC  O(1)  SC : O(1)

    Stack<Integer> s;
    int min,size;

    GetMinStack2(){
        s=new Stack<>();
        size = 0;
    }

    void push(int x) {

        if(s.isEmpty() ) {
            min=x;
            s.add(x);
        }
        else if(x<=min){
            s.add(2*x-min);
            min=x;
        }else{
            s.add(x);
        }
        size++;
    }

    int pop() {
        if (s.isEmpty()){
            return Integer.MIN_VALUE;
        }
        size--;
        int t=s.pop();
        if(t<=min){
            int res=min;
            min=2*min-t;
            return res;
        }else{
            return t;
        }
    }

    int peek() {
        int t=s.peek();
        return ((t<=min)? min : t);
    }

    int getMin() {
        return min;
    }
    int getSize(){
        return size;
    }
}


public class ImplementationGetMinStack {
    public static void main(String[] args) {

    }
}
