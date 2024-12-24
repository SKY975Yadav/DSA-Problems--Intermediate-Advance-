import java.util.ArrayList;

public class majorityElementInAnArray {
    public static void main(String[] args) {
        int [] ar = {6,6,8,9,6};
        System.out.println(majorityElement(ar));
       int a[] = {12, 7, 13, 4, 11, 6};
    }
    public static int majorityElement(int [] ar ) {//Algorithm : Moore's voting algo
        int count = 1;
        int res = 0;
        for(int i=1;i<ar.length;i++){
            if (ar[res]==ar[i]){
                count++;
            }else {
                count--;
            }
            if (count==0) {
                System.out.println(res);
                count=1;
                res = i;
            }
        }
        count = 0;
        for (int j : ar)
            if (ar[res] == j)
                count++;
        if(count <= ar.length /2)
            res = -1;

        return res;
    }
}
