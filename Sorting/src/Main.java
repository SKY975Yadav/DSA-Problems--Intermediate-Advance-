//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }

    @Override
    public String toString() {
        return ""+this.data;
    }
}
public class Main {
    public static void main(String[] args) {

    }
    static void insert(Node head,Node node){
        while (head.next != null){
            head = head.next;
        }
        head.next = node;
    }
    static Node insert(Node head,int data){
        Node temp = new Node(data);
        Node cur = head;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = temp;
        return temp;
    }
    public static void printLL(Node head){
        Node cur = head;
        while (cur!= null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
}
class Swap{
    public static void swapArray(int []a,int indX,int indY){
        int temp = a[indX];
        a[indX]= a[indY];
        a[indY]=temp;
    }
    public static void swapIntegers(IntWrapper x, IntWrapper y) {
        int temp = x.value;
        x.value = y.value;
        y.value = temp;
    }

    static class IntWrapper {
        int value;
        public IntWrapper(int value) {
            this.value = value;
        }
        public int getValue(){
            return value;
        }

        @Override
        public String toString() {
            return ""+ value; // Customize the string representation
        }
    }

}