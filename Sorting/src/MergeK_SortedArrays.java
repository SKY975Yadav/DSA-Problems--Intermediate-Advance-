import java.util.ArrayList;
import java.util.PriorityQueue;

class Triplet{
    int data,ind,kth;
    Triplet(int d,int i,int k){
        data = d;
        ind = i;
        kth = k;
    }
    @Override
    public String toString() {
        return data +" "+ ind+" "+kth;
    }
}
public class MergeK_SortedArrays {
    public static void main(String[] args) {
        int [][] arr = {
                {1,3,5,12,14},
                {2,6,8,13,19,20,23,24},
                {5,7,8},
                {11,23,24,29,31,33}
        };
        System.out.println(mergeK_SortedArrays(arr,arr.length));
    }
    public static ArrayList<Integer> mergeK_SortedArrays(int [] [] arr, int k){ // TC : O(n * log k) where n = all the elements by combined all arrays and k is the no.of arrays  SC : O(n + k)

        ArrayList<Integer> res = new ArrayList<>();
        Triplet [] [] triplets = new Triplet[k][];
        for (int i = 0; i < k; i++) {
            int len = arr[i].length;
            triplets[i] = new Triplet[len];
            for (int j = 0; j < len; j++) {
                triplets[i][j] = new Triplet(arr[i][j],j,i);
            }
        }

        PriorityQueue<Triplet> minHeap = new PriorityQueue<>((a,b)->a.data - b.data);

        for (int i = 0; i < k; i++) {
            if (arr[i].length > 0) {
                minHeap.add(triplets[i][0]);
            }
        }

        while (!minHeap.isEmpty()){

            Triplet top = minHeap.poll();
            int data = top.data,ind = top.ind,kth = top.kth;
            res.add(data);

            if (ind < triplets[kth].length-1){
                minHeap.add(triplets[kth][ind+1]);
            }
        }
        return res;
    }
}
