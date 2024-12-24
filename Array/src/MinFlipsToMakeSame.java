import java.util.Arrays;

public class MinFlipsToMakeSame {
    public static void main(String[] args) {
        int [] ar = {0,0,1,0,1,1,1,1};
        System.out.println(Arrays.toString(ar));
        System.out.println(minFlipsMakeToMakeSam(ar,ar.length));
        printMinFlipsToMakeSame(ar,ar.length);
    }
    public static int minFlipsMakeToMakeSam(int [] arr,int n){
        int zeroFlips = 0;
        int oneFlips = 0;
        int prev = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] != prev) {
                if (prev == 0) {
                    zeroFlips++;
                } else {
                    oneFlips++;
                }
                prev = arr[i];
            }
        }
        if (prev == 0) zeroFlips++;
        else oneFlips++;
        return Math.min(zeroFlips,oneFlips);
    }

    //Efficient Solution one traversal :
    public static void printMinFlipsToMakeSame(int [] arr,int n){
        int target = arr[0]==0?1:0;
        boolean groupBegin = false;
        System.out.println("invert : "+ target);
        for (int i = 1; i < n; i++) {
            if (arr[i] == target) {
                if (!groupBegin) {
                    System.out.print("From " + i + " to ");
                    groupBegin = true;
                }
            }
            else {
                if (groupBegin) {
                    System.out.println(i - 1);
                    groupBegin = false;
                }
            }
        }
        if (groupBegin){
            System.out.println(n-1);
        }

    }
}
