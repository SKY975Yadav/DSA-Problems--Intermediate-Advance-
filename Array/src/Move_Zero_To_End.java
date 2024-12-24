public class Move_Zero_To_End {
    public static void main(String[] args) {

//        int [] arr = {53,40,532,53,0,43,95,0,23,0};
//        MoveToZeroToEnd(arr);
//        System.out.println();
//        for (int j:arr){
//            System.out.print(j+" ");
//        }
    }
    private static void MoveToZeroToEnd(int [] arr){
       int count=0;
       for (int i=0;i<arr.length;i++){
           if (arr[i]!=0){
               swap(arr,i,count);
               count++;
           }
       }
    }
    private static void swap(int []arr,int a,int b){
        int t=arr[a];
        arr[a]=arr[b];
        arr[b]=t;
    }
}