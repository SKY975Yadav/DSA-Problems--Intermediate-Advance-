public class SelectionSort {
    public static void main(String[] args) {
        int [] array = {34,23,6,23,62,74,12,642,12};
        System.out.println("Before Sorting : ");
        for (int num : array)
            System.out.print(num + " ");
//        naiveImplementationOfSelectionSort(array);
        implementationOfSelectionSort(array);
        System.out.println("\nAfter Sorting : ");
        for (int num : array)
            System.out.print(num + " ");
    }
    public static void naiveImplementationOfSelectionSort(int []a){
        int []temp = new int[a.length];
        for (int i=0;i<a.length-1;i++){
            int min = 0;
            for (int j=1;j<a.length;j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            temp[i]= a[min];
            a[min]= ((int) Double.POSITIVE_INFINITY);
        }
        System.arraycopy(temp, 0, a, 0, a.length);
    }public static void implementationOfSelectionSort(int []a){
        for (int i=0;i<a.length;i++){
            int min = i;
            for (int j=i+1;j<a.length;j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            Swap.swapArray(a,i,min);
        }
    }
}