import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RepeatingElement {
    public static void main(String[] args) {
//        int[] arr = {1, 0, 2, 8, 3, 8, 8, 10, 9, 7, 8, 4};
//        System.out.println(repeatingElement(arr));
//        System.out.println(repeatingElementsMine(arr, arr.length));
//        System.out.println(Arrays.toString(arr));


//        int [] temp = {7,4,1,7,3,6,2,5};
//        System.out.println(repeatingElementsMineFrom1ToN2(temp, temp.length));

        int [] arr = {1,2,1,3,4,3};
        System.out.println(Arrays.toString(twoRepeatingElementsMineFrom1ToN2(arr, arr.length)));

//        int [] ar = { 1,3,1,2,4,2};
//        System.out.println(Arrays.toString(twoRepeated(ar, ar.length)));
    }
    //Given an array contains element from 0 to max where max is the maximum element in an array there is only
    // One repeating element we need to find that . Note that max is always <= n-2 where n is the size of array
    // The array must contains all the element from 0 to max, there is must at least 2 element in array


    public static int repeatingElement(int[] arr) {
        int slow = arr[0] + 1, fast = arr[0] + 1;
        do {
            slow = arr[slow] + 1;
            fast = arr[arr[fast] + 1] + 1;
        } while (slow != fast);
        slow = arr[0] + 1;
        while (slow != fast) {
            slow = arr[slow] + 1;
            fast = arr[fast] + 1;
        }
        return slow - 1;
    }

    public static int repeatingElementsMine(int[] arr, int n) { // TC : O(n) but it modify the array 0 to n-2 elements
        int res = -1;
        for (int i = 0; i < n; i++) {
            int temp = Math.abs(arr[i]) + 1;
            if (temp == n + 1) {
                temp = 1;
            }
            if (temp < n) {
                if (arr[temp] < 0) {
                    res = temp - 1;
                    break;
                } else if (arr[temp] == 0) {
                    arr[temp] = -n;
                } else {
                    arr[temp] *= -1;
                }
            }
        }
        for (int i = 0; i < n; i++) { // If we want our array back as same
            if (arr[i] == -n)
                arr[i] = 0;
            else {
                arr[i] = Math.abs(arr[i]);
            }
        }
        return res;
    }

    public static int repeatingElementsMineFrom1ToN2(int[] arr, int n) { // TC : O(n) but it modify the array 0 to n-2 elements
        int res = -1;
        for (int i = 0; i < n; i++) {
            int temp = Math.abs(arr[i]);
            if (arr[temp] < 0) {
                res = temp;
                break;
            } else {
                arr[temp] *= -1;
            }
        }
        for (int i = 0; i < n; i++) { // If we want our array back as same
            arr[i] = Math.abs(arr[i]);
        }
        return res;
    }
    public static int [] twoRepeatingElementsMineFrom1ToN2(int[] arr, int n) { // TC : O(n) but it modify the array 0 to n-2 elements
        int [] res = new int[2];
        int k = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int temp = Math.abs(arr[i]);
            if (arr[temp] < 0) {
                res[k++] = temp;
                count++;
                if (count==2) break;
            } else {
                arr[temp] *= -1;
            }
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < n; i++) { // If we want our array back as same
            arr[i] = Math.abs(arr[i]);
        }
        return res;
    }

// Another problem :
    /*
    Given an array arr[] of size n, find the first repeating element. The element should occur more than once and the index of its first occurrence should be the smallest.

Note:- The position you return should be according to 1-based indexing.

Example 1:

Input:
n = 7
arr[] = {1, 5, 3, 4, 3, 5, 6}
Output: 2
Explanation:
5 is appearing twice and
its first appearence is at index 2
which is less than 3 whose first
occuring index is 3.

Example 2:

Input:
n = 4
arr[] = {1, 2, 3, 4}
Output: -1
Explanation:
All elements appear only once so
answer is -1.

Your Task:
You don't need to read input or print anything. Complete the function firstRepeated() which takes arr and n as input parameters and returns the position of the first repeating element. If there is no such element, return -1.


Expected Time Complexity: O(n)
Expected Auxilliary Space: O(n)
     */
    public static int firstRepeated(int[] arr, int n) { // First Repeating Element
        // Your code here
        int res = -1;
        HashMap<Integer,Integer> hmp = new HashMap<>();
        for(int i=0;i<n;i++){
            if(hmp.containsKey(arr[i])){
                res = Math.min(res,hmp.get(arr[i]));
            }
            hmp.put(arr[i],i+1);
        }
        return res;
    }

}
