import java.util.Stack;

class MinMaxStack {
    Stack<Long> stack;
    long min;
    long max;

    MinMaxStack() {
        stack = new Stack<>();
    }

    void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = x;
            max = x;
        } else {
            stack.push(x - min);
            if (x < min) {
                min = x;
            }
            if (x > max) {
                max = x;
            }
        }
    }

    int pop() {
        if (stack.isEmpty()) {
            return Integer.MIN_VALUE; // or throw an exception
        }

        long diff = stack.pop();
        if (diff < 0) {
            int currentMin = (int) min;
            min -= diff; // Retrieve previous min
            return currentMin;
        } else if (diff > 0) {
            int currentMax = (int) max;
            max -= diff; // Retrieve previous max
            return currentMax;
        } else {
            return (int) min; // min and max are same
        }
    }

    int getMin() {
        if (stack.isEmpty()) {
            return Integer.MIN_VALUE; // or throw an exception
        }
        return (int) min;
    }

    int getMax() {
        if (stack.isEmpty()) {
            return Integer.MIN_VALUE; // or throw an exception
        }
        return (int) max;
    }

    boolean isEmpty() {
        return stack.isEmpty();
    }
}
public class ImplementationOfGetMaxAndGetMin {
    public static void main(String[] args) {

        MinMaxStack stack = new MinMaxStack();
        stack.push(10);
        stack.push(5);
        stack.push(20);
        stack.push(3);
        stack.push(15);

        System.out.println("Current min: " + stack.getMin()); // Should print 3
        System.out.println("Current max: " + stack.getMax()); // Should print 20
        System.out.println("Popped: " + stack.pop()); // Should print 15
        System.out.println("Current min: " + stack.getMin()); // Should print 3
        System.out.println("Current max: " + stack.getMax()); // Should print 20
        System.out.println("Popped: " + stack.pop()); // Should print 3
        System.out.println("Current min: " + stack.getMin()); // Should print 5
        System.out.println("Current max: " + stack.getMax()); // Should print 20
    }
}
