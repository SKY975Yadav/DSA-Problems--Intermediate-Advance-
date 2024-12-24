import java.util.LinkedList;
class TwoLinksNode{
    int data;
    TwoLinksNode next,random;
    TwoLinksNode(int data,TwoLinksNode next,TwoLinksNode random){
        this.data = data;
        this.next = next;
        this.random = random;
    }
    public String toString() {
        return ""+this.data;
    }
}
class DNode{
    int data;
    DNode prev;
    DNode next;
    DNode(int data){
        this.data = data;
        prev = null;
        next = null;
    }
}
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
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Node head = new Node(10);
        Main.insert(head,20);
        Main.insert(head,30);
        Main.insert(head,40);
        Main.insert(head,50);
        Main.insert(head,60);
        Main.insert(head,70);
        Main.insert(head,80);
        Main.insert(head,90);
        Main.insert(head,100);

//
//        Node head = new Node(10,null);
//        Node temp = head.next = new Node(20,null);
//        head.next.next = new Node(30,null);
//        head.next.next.next = new Node(40,null);
//        head.next.next.next.next = new Node(50,temp);

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
    static void insert(Node head,Node node){
        while (head.next != null){
            head = head.next;
        }
        head.next = node;
    }
    public static void printLL(Node head){
        Node cur = head;
        while (cur!= null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    public static int length(Node head){
        int len = 0;
        while (head != null){
            len++;
            head =head.next;
        }
        return len;
    }
    static TwoLinksNode insertInTwoLinksNode(TwoLinksNode head,int data){
        TwoLinksNode newNode = new TwoLinksNode(data,null,null);
        TwoLinksNode cur = head;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = newNode;
        return newNode;
    }

    public static void printTwoDLL(TwoLinksNode head){
        TwoLinksNode cur = head;
        while (cur!= null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    public static void circularTraverse(Node head){
        if (head==null) return;
        Node cur = head;
        do {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }while (cur!=head);
        System.out.println();
    }

    public static void DTraverse(DNode head){
        DNode cur = head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }


}