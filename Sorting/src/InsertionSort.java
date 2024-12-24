public class InsertionSort {
    public static void main(String[] args) {
//        int [] array = {34,23,6,23,62,74,12,642,12};
//        System.out.println("Before Sorting : ");
//        for (int num : array)
//            System.out.print(num + " ");
//        implementationOfInsertionSort(array);
//        System.out.println("\nAfter Sorting : ");
//        for (int num : array)
//            System.out.print(num + " ");
    }
    public static void implementationOfInsertionSort(int []a){
        for (int i=1;i<a.length;i++){
            int key = a[i];
            int j= i-1;
            while (j>=0 && a[j]>key){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
        }
    }
}
