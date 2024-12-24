public class Second_Largest_In_Array {
    public static void main(String[] args) {
        int [] arr = {4544,35,3,45,6443666,34,235,2342,423452};
        System.out.println(IndexOfSecondLargestElementInArray(arr));
        System.out.println(SecondLargestElementInArray(arr));
    }
    private static int IndexOfSecondLargestElementInArray(int []arr){
        int res=-1,largest=0;
        for (int i=1;i<arr.length;i++){
            if (arr[i]>arr[largest]){
                res=largest;
                largest=i;
            } else if (arr[i]<arr[largest]) {
                if (res==-1||arr[i]>arr[res])
                    res=i;
            }
        }
        return res;
    }
    private static int SecondLargestElementInArray(int []arr){
        int res=-1,largest=0;
        for (int i=1;i<arr.length;i++){
            if (arr[i]>arr[largest]){
                res=largest;
                largest=i;
            } else if (arr[i]<arr[largest]) {
                if (res==-1||arr[i]>arr[res])
                    res=i;
            }
        }
        return arr[res];
    }

}
