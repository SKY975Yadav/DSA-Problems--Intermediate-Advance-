import java.util.Arrays;
import java.util.HashMap;

public class FrequencyInSortedArray {
    public static void main(String[] args) {
        int [] ar = {7,7,8,8,8,9,9,9,9,9,11};
        frequencyInSortedArray(ar);
    }
    public static void frequencyInSortedArray(int [] ar){
        int freq = 1;
        for (int i =1 ;i<ar.length;i++){
            if(ar[i-1]!=ar[i]){
                System.out.println(ar[i-1]+" : "+freq+" ");
                freq = 1;
            }
            else {
                freq++;
            }
        }
        System.out.println(ar[ar.length-1]+" : "+freq);
    }
}
