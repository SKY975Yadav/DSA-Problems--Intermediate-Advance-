class StackForArray{
    private int top;
    private final int cap;
    int [] ar;
    StackForArray(int x){
        this.cap = x;
        ar = new int[cap];
        top = -1;
    }
    void push(int data){
        if (top==cap-1){
            System.out.println("Cannot push the element in stack! Stack is full");
            return;
        }
        top++;
        ar[top] = data;
    }
    int pop(){
        if (top==-1){
            System.out.print("Cannot pop the element in the stack! Stack is empty");
            return -1;
        }
        int res = ar[top];
//        ar[top] = -1;
        top--;
        return res;
    }
    int peek(){
        if (top==-1){
            System.out.print("Cannot peek the element in the stack! Stack is empty");
            return -1;
        }
        return ar[top];
    }
    int size(){
        return top+1;
    }
    boolean isEmpty(){
        return top == -1;
    }
    // Should not
//    void displayStack(){
//        for(int i : ar){
//            System.out.print(i+" ");
//        }
//        System.out.println();
//    }
}
public class ImplementationOfStackUsingArray {
    public static void main(String[] args) {
        StackForArray my = new StackForArray(5);
        my.push(15);
        my.push(20);
        my.push(30);
        my.push(40);
        my.push(50);
//        System.out.println(my.pop());
//        System.out.println(my.pop());
//        System.out.println(my.pop());
//        System.out.println(my.pop());
//        System.out.println(my.pop());
//        System.out.println(my.peek());
//        System.out.println(my.pop());
//
//        System.out.println(my.peek());
//        my.push(80);
//        my.push(100);
//        System.out.println(my.peek());


        //Internal in stack
//        my.push(5);
//        my.displayStack();
//        System.out.println(my.pop());
//        my.displayStack();
//        my.push(100);
//        my.displayStack();
    }
}
