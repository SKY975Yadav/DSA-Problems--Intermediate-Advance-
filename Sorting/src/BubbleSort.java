public class BubbleSort {
    public static void main(String[] args) {
        int [] array = {34,23,6,23,62,74,12,642,12};
        System.out.println("Before Sorting : ");
        for (int num : array)
            System.out.print(num + " ");
        implementationOfBubbleSort(array);
        System.out.println("\nAfter Sorting : ");
        for (int num : array)
            System.out.print(num + " ");
    }
    public static void implementationOfBubbleSort(int []a){
        for (int i=0;i<a.length-1;i++){
            boolean bf = false;
            for (int j=0;j<a.length-i-1;j++){
                if (a[j]>a[j+1]) {
                    Swap.swapArray(a,j,j+1);
                    bf = true;
                }
            }
            if (!bf) break;
        }
    }
}
