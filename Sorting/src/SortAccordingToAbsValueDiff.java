import  java.util.*;

public class SortAccordingToAbsValueDiff {
    public static void main(String[] args) {
        List<Integer>li = new ArrayList<>();
        li.add(3);
        li.add(10);
        li.add(2);
        li.add(5);
        li.add(8);
        System.out.println(li);
        sortABS(li,li.size(),7);
        System.out.println(li);

    }
    static void sortABS(List<Integer> arr, int n, int k)
    {
        // add your code here
        arr.sort((e1, e2) -> {
            int diff1 = Math.abs(e1 - k);
            int diff2 = Math.abs(e2 - k);

            return Integer.compare(diff1, diff2);
        });
    }

}
