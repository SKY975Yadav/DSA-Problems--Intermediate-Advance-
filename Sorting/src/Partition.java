public class Partition {
    public static void main(String[] args) {
        int [] exm = {3,2};
        System.out.println("Before Partition : ");
        for (int num : exm) System.out.print(num+" ");
        System.out.println();
//        naiveImplementationOfPartition(exm,2,exm.length-2,5);
//        System.out.println(implementationOfLomutoAlgoOfPartition(exm,2,exm.length-2,8));
        System.out.println(implementationOfHoareAlgoPartition(exm,0,exm.length-1,0));
        System.out.println("After Partition : ");
        for (int num : exm) System.out.print(num+" ");
        System.out.println();
    }
    public static void naiveImplementationOfPartition(int [] ar,int low,int high,int pivot){//Naive But Stable
        int [] temp = new int[high-low+1];
        int ind=0,a=0;
        boolean bo = false;
        for (int i=low;i<=high;i++){
            if (ar[i]<pivot) {
                temp[ind] = ar[i];
                ind++;
            }
            if (ar[i]==pivot){
                a=i;
                bo = true;
            }
        }
        if (bo){
            temp[ind]=ar[a];
            ind++;
        }
//        int res = temp[ind-1]; if we want to return the p position
        for (int i=low;i<=high;i++){
            if (ar[i]>pivot) {
                temp[ind] = ar[i];
                ind++;
            }
        }
        int tem =0;
        for (int i=low;i<=high;i++){
            ar[i]= temp[tem];
            tem++;
        }
//        return res; if we want to return the p position
    }
    public static int implementationOfLomutoAlgoOfPartition(int [] ar,int low,int high,int p){//here p is the index of pivot
        Swap.swapArray(ar,p,high);// It's must that the pivot is should be in the last element in array in this algo
        int pivot = ar[high];
        int i=low-1;
        for (int j=low;j<=high-1;j++){
            if (ar[j]<pivot){
                i++;
                Swap.swapArray(ar,i,j);
            }
        }
        Swap.swapArray(ar,i+1,high);
        return i+1;
    }
    public static int implementationOfHoareAlgoPartition(int[] arr, int l, int h, int p){ //In this algo we can't pivot at correct place
        Swap.swapArray(arr,l,p);
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
}
