import java.util.Arrays;
import java.util.Stack;

public class PreviousSmallerAndNextSmallerElement {
    public static void main(String[] args) {
        int[] arr = {15, 10, 12, 12, 4, 6, 2, 8};
        int[] res = previousSmallerElement(arr, arr.length);
        int [] res2 = nextSmallerElement(arr, arr.length);
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(res2));
    }
    public static int[] previousSmallerElement(int [] arr,int n){
        int[] res = new int[n];
        res[0] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i = 1; i < n; i++) {

            while (!stack.isEmpty() && arr[i] <= stack.peek()) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return res;
    }

    public static int [] nextSmallerElement(int [] arr, int n){
        int[] res = new int[n];
        res[n-1] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[n-1]);

        for (int i = n-2; i >=0 ; i--) {

            while (!stack.isEmpty() && arr[i] <= stack.peek()){
                stack.pop();
            }
            res[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(arr[i]);
        }
        return res;
    }

}
