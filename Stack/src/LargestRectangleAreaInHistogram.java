import java.util.Stack;

public class LargestRectangleAreaInHistogram {
    public static void main(String[] args) {
        int [] arr = {1,3,3,1};
        System.out.println(largestRectAreaInHistogram(arr, arr.length));
        System.out.println(largestRectangleArea(arr, arr.length));
    }

    public static int  largestRectAreaInHistogram(int [] arr,int n){ // O(n) and O(n)

        int res = Integer.MIN_VALUE;
        int [] prevSmaller = prevSmallerElement(arr);
        int [] nextSmaller = nextSmallerElement(arr);
        for (int i = 0 ; i < n;i++){
            int curSum = arr[i];

            curSum += (i - prevSmaller[i] - 1)*arr[i];
            curSum += (nextSmaller[i]-i-1)*arr[i];
            res = Math.max(res,curSum);
        }
        return res;
    }

    private static int[] prevSmallerElement(int [] arr){
        int n = arr.length;

        int [] res = new int[n];
        res[0] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        for (int i = 1; i <n; i++) {

            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
                stack.pop();
            }
            res[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        return res;
    }

    public static int [] nextSmallerElement(int [] arr){
        int n= arr.length;

        int[] res = new int[n];
        res[n-1] = n;
        Stack<Integer> stack = new Stack<>();
        stack.push(n-1);

        for (int i = n-2; i >=0 ; i--) {

            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
                stack.pop();
            }
            res[i] = stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        return res;
    }

    public static int largestRectangleArea(int [] arr, int n){ // TC :O(N)

        int res = 0;
        int cur ;
        Stack<Integer> st = new Stack<>(); // SC: O(N)
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]){
                int temp = st.pop();
                cur = arr[temp] * (st.isEmpty()? i : (i-st.peek()-1));
                res = Math.max(cur,res);
            }
            st.push(i);
        }

        while (!st.isEmpty()){
            int temp = st.pop();
            cur = arr[temp] * (st.isEmpty()? n : (n-st.peek()-1));
            res = Math.max(cur,res);
        }
        return res;
    }


}
