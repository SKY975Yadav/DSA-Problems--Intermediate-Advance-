import java.lang.reflect.Array;
import java.util.Arrays;

public class RotateAnArray {
    public static void main(String[] args) {
        int [] ar = new int[]{1,2,3,4,5};
        leftRotateAnArray(ar,3);
//        rightRotateAnArray(ar,2);
        System.out.println(Arrays.toString(ar));
    }
    static void leftRotateAnArray(int [] ar,int d){
        reverseAnArray(ar,0,d-1);
        reverseAnArray(ar,d,ar.length-1);
        reverseAnArray(ar,0, ar.length-1);
    }
    static void rightRotateAnArray(int [] ar,int d){
        d = ar.length-d;
        reverseAnArray(ar,0,d-1);
        reverseAnArray(ar,d,ar.length-1);
        reverseAnArray(ar,0, ar.length-1);
    }
    static void reverseAnArray(int [] ar, int low, int high){
        while (low<high){
            Main.swap(ar,low,high);
            low++;
            high--;
        }
    }

}
