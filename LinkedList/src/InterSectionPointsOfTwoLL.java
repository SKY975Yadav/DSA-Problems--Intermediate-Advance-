public class InterSectionPointsOfTwoLL {
    public static void main(String[] args) {

        Node head1 = new Node(10);
        Main.insert(head1,20);
        Main.insert(head1,30);
        Main.insert(head1,40);
        Node temp = Main.insert(head1,50);
        Main.insert(head1,60);
        Main.insert(head1,70);
        Main.insert(head1,80);
        Main.insert(head1,90);
        Main.insert(head1,100);

        Node head2 = new Node(25);
        Main.insert(head2,35);
        Main.insert(head2,45);
        Main.insert(head2,temp);

        Main.printLL(head1);
        Main.printLL(head2);

        System.out.println(intersectionOfTwoPoints(head1,head2));

    }
    static Node intersectionOfTwoPoints(Node head1,Node head2){

        int count1 = Main.length(head1);
        int count2 = Main.length(head2);

        if (count1 < count2){
            int temp = count1;
            count1 = count2;
            count2 = temp;
            Node tempNode = head1;
            head1 = head2;
            head2 = tempNode;
        }


        int diff = count1 - count2;
        for (int i = 0; i < diff; i++) {
            head1 = head1.next;
        }

        while (head1!=null && head2!=null){
            if (head1 == head2){
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;

        }
        return null;
    }
}
