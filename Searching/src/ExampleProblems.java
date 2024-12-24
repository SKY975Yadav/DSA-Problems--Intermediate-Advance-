import java.util.Arrays;
import java.util.HashMap;

public class ExampleProblems {
    public static void main(String[] args) {
//        System.out.println(countOnes(new int[]{1,1,1,0,0}));
//        int ans = naiveMajorityElement(new int[]{2,1,3,8,3,2,2,2,2,5,2,6,1,2,2});
//        int ans = majorityElement(new int[]{2,1,3,8,3,2,2,2,2,5,2,6,1,2,2});
        int ans = majorityElementUsingHashing(new int[]{2, 1, 3, 8, 3, 2, 2, 2, 2, 5, 2, 6, 1, 2, 2});
        System.out.println(ans);
    }
    //    BigO(N)
    static int majorityElementUsingMoyAlgo(int a[]) {
        // your code here
        int count = 0;
        int elem = 0;
        for (int num : a) {
            if (count == 0) {
                elem = num;
                count++;
            } else if (num == elem)
                count++;
            else
                count--;
        }
        int count1 = 0;
        for (int num : a) {
            if (elem == num)
                count1++;
        }
        if (count1 > a.length / 2) {
            return elem;
        }
        return -1;
    }

    //    TC : O(n2)
    public static int naiveMajorityElement(int a[]) {
        // your code here
        Arrays.sort(a);
        int totalCount = 0;
        int majElem = 0;
        for (int i = 0; i < a.length; i++) {
            int count = 0;
            int elem = 0;
            for (int j = i; j < a.length; j++) {
                if (a[i] != a[j]) {
                    count = j - i;
                    elem = a[i];
                    i = j - 1;
                    break;
                }
            }
            if (count > totalCount) {
                majElem = elem;
                totalCount = count;
            }
        }
        if (totalCount > a.length / 2)
            return majElem;
        return -1;
    }

    //    BigO(n)
    public static int majorityElementUsingHashing(int[] a) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int x : a) {
            hm.put(x, hm.getOrDefault(x, 0) + 1);
            if (hm.get(x) > a.length / 2) {
                return x;
            }
        }
        return -1;
    }
    private static int countOnes(int [] arr){
        // Your code here
        int low = 0;
        int high = arr.length-1;
        int count = -1;
        while(low<=high) {
            int mid = (low + high) / 2;
            if (arr[mid] == 1) {
                low = mid + 1;
                count = mid;
            } else {
                high = mid - 1;
            }
        }
        return count+1;
    }
}
