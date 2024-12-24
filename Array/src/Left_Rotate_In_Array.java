public class Left_Rotate_In_Array {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
//        LeftRotateByOneInArray(arr);
        LeftRotateByDInArray(arr,3);
        for (int j:arr){
            System.out.print(j+" ");
        }
    }
    public static void LeftRotateByOneInArray(int [] arr){
        int temp=arr[0];
        for (int i=1;i<arr.length;i++){
            arr[i-1]=arr[i];
        }
        arr[arr.length-1]=temp;
    }
    public static void LeftRotateByDInArray(int [] arr,int d){
        int n=arr.length;
        reverse(arr,0,d-1);
        reverse(arr,d,n-1);
        reverse(arr,0,n-1);
    }
    public static void reverse(int []arr,int low, int high){
        while (low<high){
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
            low++;
            high--;
        }
    }
}
