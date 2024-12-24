import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Pair{
    int start;
    int end;
    Pair(int start , int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "{"+this.start+", "+this.end+"}";
    }

    public boolean equals(Pair obj) {
        return this.start == obj.start && this.end == obj.end;
    }
}
public class MergeOverlapping {
    public static void main(String[] args) {
        Pair[] al = {new Pair(5,10),
                new Pair(3,15),
                new Pair(18,30),
                new Pair(2,7)};

        System.out.println(mergeOverlapOfIntervals(al));
    }

    public static ArrayList<Pair> mergeOverlapOfIntervals(Pair [] inp){ // It modify original array if we want our array to not change , then created an temp array and copy them

        Pair [] arr = Arrays.copyOf(inp,inp.length);  // just to not modify the original array, don't need if we you can modify the original array

        ArrayList<Pair> resPairs = new ArrayList<>();


        Comparator<Pair> cmp = Comparator.comparingInt(o -> o.start);
        Arrays.sort(arr,cmp);
        int res = 0;

        for (int i = 1; i < arr.length; i++) {

            if (arr[res].end >= arr[i].start){
                arr[res].start = Math.min(arr[res].start,arr[i].start);
                arr[res].end = Math.max(arr[res].end,arr[i].end);
            }
            else {
                resPairs.add(arr[res]);
                res++;
                arr[res] = arr[i];
            }
        }
        resPairs.add(arr[res]);
        return resPairs;
    }

}
