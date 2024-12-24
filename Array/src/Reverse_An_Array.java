public class Reverse_An_Array {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9};
        ReverseAnArray(arr);
    }
    private static void ReverseAnArray(int []arr){
        int temp;
        int n= arr.length-1;
        for (int i=0;i<arr.length/2;i++){
            temp=arr[i];
            arr[i]=arr[n];
            arr[n]=temp;
            n--;
        }
        for(int j : arr){
            System.out.print(j+" ");
        }
    }
}
