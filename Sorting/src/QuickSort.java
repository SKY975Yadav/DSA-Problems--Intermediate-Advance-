public class QuickSort {
    public static void main(String[] args) {
        int [] exm = {3,2,5,3,5,23,72,22,464,246,24,272,24,42};
        System.out.println("Before Sorting : ");
        for (int num : exm) System.out.print(num+" ");
        System.out.println();
        quickSort(exm,0,exm.length-1);
        System.out.println("After Sorting : ");
        for (int num : exm) System.out.print(num+" ");
        System.out.println();
    }
    public static void quickSort(int []ar,int low,int high){
        if (low<high){
            int p = implementationOfHoareAlgoPartition(ar,low,high);
            quickSort(ar,low,p);
            quickSort(ar,p+1,high);
        }
    }
    public static int implementationOfHoareAlgoPartition(int[] arr, int l, int h){ //In this algo we can't pivot at correct place
        int pivot=arr[l];
        int i=l-1,j=h+1;
        while(true){
            do{
                i++;
            }while(arr[i]<pivot);
            do{
                j--;
            }while(arr[j]>pivot);
            if(i>=j)return j;
            Swap.swapArray(arr,i,j);
        }
    }
    public static  int implementationOfLomutoPartition(int [] arr, int l , int h){

        int pivot = arr[h];
        int i = l-1;
        for (int j = l; j<h;j++){
            if (arr[j]<pivot){
                i++;
                Swap.swapArray(arr,j,i);
            }
        }
        Swap.swapArray(arr,i+1,h);
        return i+1;
    }
}