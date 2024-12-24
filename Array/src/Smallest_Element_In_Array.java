public class Smallest_Element_In_Array {
    public static void main(String[] args) {
        int [] arr = {12,5,35,2,253,63,64,4};
        System.out.println(IndexOfSmallestElementInArray(arr));
        System.out.println(SmallestElementInArray(arr));
    }
    private static int IndexOfSmallestElementInArray(int[] arr){
        int k=0;
        for (int i=1;i<arr.length;i++){
            if (arr[i]<arr[k]){
                k=i;
            }
        }
        return k;
    }
    private static int SmallestElementInArray(int[] arr){
        int num = Integer.MAX_VALUE;
        for (int j : arr) {
            if(j < num) {
                num = j;
            }
        }
        return num;
    }
}
