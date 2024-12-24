import java.util.Arrays;

public class MinDifferenceInAnArray {
    public static void main(String[] args) {
        int [] c = {41,13,2,63,73,75};
        System.out.println(minimumDifferenceInArray(c));
    }

    public static int minimumDifferenceInArray(int []ar){ //O(n log n)
        Arrays.sort(ar);
        int min = Integer.MAX_VALUE;
        for (int i=1;i<ar.length;i++){
            if (ar[i]-ar[i-1]<min){
                min=ar[i]-ar[i-1];
            }
        }
        return min;
    }
}
