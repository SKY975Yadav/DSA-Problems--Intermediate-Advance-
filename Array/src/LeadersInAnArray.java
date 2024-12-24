import java.util.*;

public class LeadersInAnArray {
    public static void main(String[] args) {

        int [] ar = {7,10,4,3,6,5,2};
        
//        leaders(ar);
//        int a = 10;
//        int b = 20;
//        System.out.println(a+" "+ b);
//        a = (a+b) - (b=a);
//        System.out.println(a+" "+b);
    }
    public static int[] replaceElements(int[] arr) {
        int n = arr.length;
        int max = arr[n-1];
        arr[n-1] = -1;
        for (int i= n-2;i>=0;i--){
            arr[i] = max;
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return arr;
    }
    static void leaders(int []ar){
        ArrayList<Integer> al = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i= ar.length-2;i>=0;i--){
            if (ar[i]>max){
                al.add(ar[i]); //or simply use sout
                max = ar[i];
            }
        }
        ListIterator<Integer> it = al.listIterator(al.size());
        while (it.hasPrevious()){
            System.out.print(it.previous()+" ");
        }
    }
}
