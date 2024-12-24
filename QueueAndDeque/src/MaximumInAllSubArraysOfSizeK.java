import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumInAllSubArraysOfSizeK {
    public static void main(String[] args) {
        int [] arr = {6,10,5,21,12,14,5,19};
//        maxInAllSubArrOfSizeK(arr,3);
        for (int i = 0; i < 10; ++i) {
            System.out.println(i);
        }
    }

    public static void maxInAllSubArrOfSizeK(int [] arr,int k){
        int n= arr.length;
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < k; ++i) {

           while (!dq.isEmpty() && arr[i]>=arr[dq.getLast()]){
               dq.removeLast();
           }

           dq.addLast(i);
        }

        for (int i = k; i < n; ++i) {

            System.out.print(arr[dq.getFirst()]+" ");

            while (!dq.isEmpty() && dq.getFirst()<= i-k){
                dq.removeFirst();
            }

            while (!dq.isEmpty() && arr[i]>=arr[dq.getLast()]){
                dq.removeLast();
            }

            dq.addLast(i);
        }
        System.out.print(arr[dq.getFirst()]+" ");

    }
}




