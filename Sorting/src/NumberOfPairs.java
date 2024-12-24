import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;



public class NumberOfPairs {
    public static void main(String[] args) {
        int [] arr1  = { 2,4,6,7};
        int [] arr2 = {1,3,4,5};
        System.out.println(countPairs(arr1,arr2, arr1.length, arr2.length));
    }



    // No.of pairs such that x^y > y^x

    static long countPairs(int x[], int y[], int m, int n)
    {
        // your code here
        Arrays.sort(y);
        long res = 0;
        int [] noOf = new int [5];
        for(int i = 0 ;i<n;i++){
            if(y[i]>=5) break;
            noOf[y[i]]++;
        }

        for(int i = 0 ; i < m ;i++){
            res += count(x[i],y,n,noOf);
        }
        return res;

    }

    static long count(int x , int [] y, int n , int [] noOf){

        if(x==0){
            return 0;
        }
        if(x == 1){
            return noOf[0];
        }

        long res = 0;

        int ind = Arrays.binarySearch(y,x);

        if(ind < 0){
            ind = Math.abs(ind + 1);
            res += n - ind;
        }
        else{

            while(ind < n && y[ind] == x){
                ind++;
            }
            res += n - ind;
        }

        if(x == 2){
            res -= (noOf[3] + noOf[4]);
        }

        if(x == 3){
            res += noOf[2];
        }

        return res;

    }
}
