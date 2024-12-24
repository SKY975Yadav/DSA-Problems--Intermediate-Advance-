import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        int [] arr = {60,10,20,30,40,35,30,50,70,65};
        int [] res = stockSpan(arr, arr.length);
        System.out.println(Arrays.toString(res));
    }
    public static int [] stockSpan(int [] arr,int n){
        int [] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        stack.add(0);
        res[0] = 1;
        for (int i = 1; i < n; i++) {

            while (!stack.isEmpty() && arr[i] > arr[stack.peek()] )
                stack.pop();

            res[i] = stack.isEmpty()? i+1 : i - stack.peek();
            stack.push(i);
        }
        return res;
    }

}
