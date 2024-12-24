import java.util.ArrayList;

class StackUsingArrayList{
    private final ArrayList<Integer> al = new ArrayList<>();
    void push(int x){
        al.add(x);
    }
    int pop(){
        if (al.isEmpty()){
            System.out.print("Stack is empty");
            return -1;
        }
        int res = al.get(al.size()-1);
        al.remove(al.size()-1);
        return res;
    }
    int peek(){
        if (al.isEmpty()){
            System.out.print("Stack is empty");
            return -1;
        }
        return al.get(al.size()-1);
    }
    boolean isEmpty(){
        return al.isEmpty();
    }
    int size(){
        return al.size();
    }
//    void display(){
//        System.out.println(al);
//    }
}
public class ImplementationOfStackUsingArrayList {
    public static void main(String[] args) {
        StackUsingArrayList sal = new StackUsingArrayList();
        sal.push(5);
        sal.push(43);
        sal.push(56);
        sal.push(62);
        sal.push(74);
        sal.push(94);
        sal.push(624);
        sal.push(423);
        System.out.println(sal.peek());
        System.out.println(sal.pop());
        System.out.println(sal.peek());
        System.out.println(sal.size());

        //just for understanding don't use display
//        sal.display();
        System.out.println(sal.isEmpty());
        sal.pop();
        sal.pop();
        sal.pop();
        sal.pop();
        sal.pop();
        sal.pop();
        sal.pop();
        sal.pop();//stack is empty
        sal.peek();//stack is empty
        System.out.println(sal.isEmpty());
//        sal.display();
    }
}
