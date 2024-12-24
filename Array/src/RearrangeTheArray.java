import java.util.Arrays;

public class RearrangeTheArray {
    public static void main(String[] args) {
//        int [] ar = {4,0,2,1,3};
//        System.out.println(Arrays.toString(ar));
//        reArrangeTheArray(ar,ar.length);
//        System.out.println(Arrays.toString(ar));

        int [] ar = {1,2,3,4,5};
        reArrangeTheArray(ar,ar.length);
        System.out.println(Arrays.toString(ar));

    }
    public static void rearrangeTheArray(int [] arr,int n){ // Rearrange the array as arr[i] = arr[arr[i]]
        for (int i=0;i<n;i++){
            arr[i] += (arr[arr[i]] % n)*n;
        }
        for (int i = 0; i < n; i++) {
            arr[i] /= n;
        }
    }
    public static void reArrangeTheArray(int [] arr,int n){//ReArrange the given sorted array as alternatively ex : {1,2,3,4,5,6}   ==>  {6,1,5,2,4,3}
        int [] allMax,allMin;
        if(n%2==0) allMax = new int[n/2];
        else allMax = new int[n/2+1];
        allMin = new int[n/2];
        int k = 0;
        for(int i=n-1;i>=n/2;i--){
            allMax[k] = arr[i];
            k++;
        }
        for(int i=0;i<n/2;i++){
            allMin[i] = arr[i];
        }
        int x = 0,y=0;
        for(int i = 0;i<n;i++){
            if(i%2==0){
                arr[i] = allMax[x];
                x++;
            }
            else {
                arr[i] = allMin[y];
                y++;
            }
        }
    }
}
