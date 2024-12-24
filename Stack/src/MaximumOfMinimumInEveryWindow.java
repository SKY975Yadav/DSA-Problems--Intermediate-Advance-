import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MaximumOfMinimumInEveryWindow {
    public static void main(String[] args) {
        int []arr = {10,20,30,50,10,70,30};
        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(maxOfMinInEveryWindow(arr)));
//        System.out.println(Arrays.toString(getMaxWindow(arr, arr.length)));
        System.out.println(Arrays.toString(maxOfMin(arr)));
    }
    private static int[] getMaxWindow(int [] arr,int n){ // return the minElm on rigt - minElem on Right - 1 for every element

        int[] res = new int [n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < n ; i++){
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                int top = stack.pop();
                res[top] = stack.isEmpty()? i :  (i - stack.peek()-1);
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int top = stack.pop();
            res[top] = stack.isEmpty()? n : (n - stack.peek()-1);
        }
        return res;
    }


    public static int[] maxOfMin(int [] arr){ // O(n) solution
        int n = arr.length;
        int [] len = getMaxWindow(arr,n);
        int [] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[len[i]-1] = Math.max(res[len[i]-1], arr[i]);
        }
        for (int i = n-2; i >= 0; i--) {
            res[i] = Math.max(res[i],res[i+1]);
        }
        return res;
    }






    public static int [] maxOfMinInEveryWindow(int [] arr){ // Naive Solution : O(n^2) Tc
        int n = arr.length;
        int [] res = new int[n];
        for (int k = 1; k <= n; k++) {
            res[k-1] = maxOfMinOfThisWindow(arr,n,k);
        }
        return res;
    }

    private static int maxOfMinOfThisWindow(int [] arr,int n,int k){ // K is the Window size helper method

        Deque<Integer> dq = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {

            if (!dq.isEmpty() && dq.peekFirst() < i-k+1){
                dq.pollFirst();
            }

            while (!dq.isEmpty() && arr[dq.peekLast()] > arr[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if (i >= k -1 ){
                max = Math.max(max,arr[dq.getFirst()]);
            }
        }
        return max;

    }
}
