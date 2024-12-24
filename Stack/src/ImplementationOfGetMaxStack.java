import java.util.Stack;

class GetMaxStack {  //TC  O(1)  SC : O(1)

    Stack<Integer> s;
    int max, size;

    GetMaxStack() {
        s = new Stack<>();
        size = 0;
    }

    void push(int x) { // -5,-14,-3,15,-12,pop,pop,-3,pop,pop

        if (s.isEmpty()) {
            max = x;
            s.add(x);
        } else if (x >= max) {
            s.add((2 * x) - max); // Store the new max encoded with the difference
            max = x;
        } else {
            s.add(x);
        }
        size++;
    }

    int pop() {
        if (s.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        size--;
        int t = s.pop();
        if (t >= max) {
            int res = max;
            max = (2 * max) - t; // Decode the old max
            return res;
        } else {
            return t;
        }
    }

    int peek() {
        int t = s.peek();
        return (t >= max) ? max : t;
    }

    int getmax() {
        return max;
    }

    int getSize() {
        return size;
    }
}

public class ImplementationOfGetMaxStack {
    public static void main(String[] args) {
        GetMaxStack stack = new GetMaxStack();
        stack.push(-5);
        stack.push(-14);
        stack.push(-3);
        stack.push(15);
        stack.push(-12);

        System.out.println("Current max: " + stack.getmax()); // Should print 15
        System.out.println("Popped: " + stack.pop()); // Should print -12
        System.out.println("Current max: " + stack.getmax()); // Should print 15
        System.out.println("Popped: " + stack.pop()); // Should print 15
        System.out.println("Current max: " + stack.getmax()); // Should print -3
        stack.push(-3);
        System.out.println("Current max: " + stack.getmax()); // Should print -3
        System.out.println("Popped: " + stack.pop()); // Should print -3
        System.out.println("Popped: " + stack.pop()); // Should print -3
        System.out.println("Current max: " + stack.getmax()); // Should print -14
    }
}
