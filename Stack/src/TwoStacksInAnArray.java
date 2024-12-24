import java.util.ArrayList;

class DynamicTwoStacksInAnArray<T> {
    private int top1;
    private int top2;
    private int cap;
    private final ArrayList<T> arrayList;
    DynamicTwoStacksInAnArray() {
        this.cap = 20;
        arrayList = new ArrayList<>(cap);
        // Initializing the array list with null values to avoid IndexOutOfBoundsException
        for (int i = 0; i < cap; i++) {
            arrayList.add(null);
        }
        top1 = -1;
        top2 = cap;
    }

    DynamicTwoStacksInAnArray(int initialCap) {
        this.cap = initialCap;
        arrayList = new ArrayList<>(cap);
        // Initializing the array list with null values to avoid IndexOutOfBoundsException
        for (int i = 0; i < cap; i++) {
            arrayList.add(null);
        }
        top1 = -1;
        top2 = cap;
    }

    public void push1(T data) {
        if (top1 == top2 - 1) {
            growStack();
        }
        top1++;
        arrayList.set(top1, data);
    }

    public void push2(T data) {
        if (top2 == top1 + 1) {
            growStack();
        }
        top2--;
        arrayList.set(top2, data);
    }

    public T pop1() {
        if (top1 >= 0) {
            T temp = arrayList.get(top1);
            arrayList.set(top1, null); // Clear the slot
            top1--;
            return temp;
        }
        return null;
    }

    public T pop2() {
        if (top2 < cap) {
            T temp = arrayList.get(top2);
            arrayList.set(top2, null); // Clear the slot
            top2++;
            return temp;
        }
        return null;
    }

    public int size1() {
        return top1 + 1;
    }

    public int size2() {
        return cap - top2;
    }

    private void growStack() {
        int newCap = 2 * cap;
        ArrayList<T> newArrayList = new ArrayList<>(newCap);

        // Initialize new array list with null values
        for (int i = 0; i < newCap; i++) {
            newArrayList.add(null);
        }

        // Copy elements from the first stack
        for (int i = 0; i <= top1; i++) {
            newArrayList.set(i, arrayList.get(i));
        }

        // Calculate the new starting index for the second stack in the new array
        int newTop2 = newCap - (cap - top2);

        // Copy elements from the second stack to their new positions in the expanded array
        for (int i = top2; i < cap; i++) {
            newArrayList.set(i + (newCap - cap), arrayList.get(i));
        }

        // Update the top2 index to the new starting index
        top2 = newTop2;

        // Update the capacity to the new capacity
        cap = newCap;

        // Update arrayList reference to the new array
        arrayList.clear();
        arrayList.addAll(newArrayList);
    }
}
class TwoStacks<T>{
    private int top1;
    private int top2;
    private final int cap;
    private final T [] arr;

    TwoStacks(int cap){
        this.cap = cap;
        arr = (T[]) new Object[cap];
        top1 = -1;
        top2 = cap;
    }

    public boolean push1(T data){
        if (top1 < top2-1){
            top1++;
            arr[top1] = data;
            return true;
        }
        else return false;
    }
    public boolean push2(T data){
        if (top2 > top1+1){
            top2--;
            arr[top2] = data;
            return true;
        }
        else return false;
    }
    public T pop1(){
        if (top1>=0){
            T temp = arr[top1];
            top1--;
            return temp;
        }
        return null;
    }
    public T pop2(){
        if (top2 < cap){
            T temp = arr[top2];
            top2++;
            return temp;
        }
        return null;
    }
    public int size1(){
        return top1+1;
    }
    public int size2(){
        return cap-top2;
    }
}





public class TwoStacksInAnArray {
    public static void main(String[] args) {
//        TwoStacks<Integer> ts = new TwoStacks<>(10);
//        ts.push1(10);
//        ts.push1(11);
//        ts.push1(12);
//        ts.push1(13);
//        ts.push2(14);
//        ts.push2(15);
//        ts.push2(16);
//        ts.push2(17);
//        ts.push2(18);
//        System.out.println(ts.push2(20));
//        System.out.println(ts.pop1());
//        System.out.println(ts.push1(34));

        DynamicTwoStacksInAnArray<Integer> tls = new DynamicTwoStacksInAnArray<>(10);
        tls.push1(10);
        tls.push1(20);
        tls.push1(30);
        tls.push1(40);
        tls.push1(50);
        tls.push1(60);
        tls.push1(70);
        tls.push1(80);

        tls.push2(90);
        tls.push2(100);
        tls.push2(110);
        tls.push2(120);
        System.out.println(tls.pop1());
        System.out.println(tls.pop2());

    }
}
