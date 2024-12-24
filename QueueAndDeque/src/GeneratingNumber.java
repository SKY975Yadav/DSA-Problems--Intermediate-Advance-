import java.util.LinkedList;
import java.util.Queue;

public class GeneratingNumber {
    public static void main(String[] args) {
        printFirstNFor5And6(10);
        printFirstN(50);
    }
    static void printFirstNFor5And6(int n) // Generate first n numbers that contains only 5 and 6 ex: 5 6 55 56 65 66
    {
        Queue<String> q = new LinkedList<>();

        q.add("5");
        q.add("6");

        for(int i = 0; i < n; i++)
        {
            String curr = q.poll();

            System.out.print(curr+ " ");

            q.add(curr + "5");
            q.add(curr + "6");
        }
        System.out.println();

    }

    static void printFirstN(int n) // all numbers that contains 1 to 5 only
    {
        Queue<String> q = new LinkedList<>();

        for (int i = 1; i <= 5; i++) {
            q.add(i+"");
        }

        for(int i = 0; i < n; i++)
        {
            String curr = q.poll();

            System.out.print(curr+ " ");

            for (int j = 1; j <= 5; j++) {
                q.add(curr+j);
            }
        }
        System.out.println();

    }


}
