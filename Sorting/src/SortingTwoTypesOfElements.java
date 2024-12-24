import java.util.Arrays;

public class SortingTwoTypesOfElements {
    public static void main(String[] args) {
        int [] d = {-12,23,-2,5,-3};
        int [] e = {1,4,2,6,12,6,35,2,3,6,21,9};
        int []f = {0,1,1,1,0,0,0,1,1,0,1,1,0,0,0};

        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.toString(e));
        System.out.println(Arrays.toString(f));

        sortingTwoTypesOfElementsOfPositiveAndNegative(d);
        sortingTwoTypesOfElementsOfEvenAndOdd(e);
        sortingTwoTypesOfElementsOfBinaryArray(f);

        System.out.println("After Sorting : ");

        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.toString(e));
        System.out.println(Arrays.toString(f));
    }
    public static void sortingTwoTypesOfElementsOfPositiveAndNegative(int[]ar) {
        int i = -1;
        int j = ar.length;
        while (true) {
            do {
                i++;
            } while (i<ar.length && ar[i] < 0);
            do {
                j--;
            } while (j>=0 && ar[j] > 0);
            if (i>=j) return;
            Swap.swapArray(ar,i,j);
        }
    }
    public static void sortingTwoTypesOfElementsOfEvenAndOdd(int[]ar) {
        int i = -1;
        int j = ar.length;
        while (true) {
            do {
                i++;
            } while (i<ar.length && ar[i] % 2 == 0);
            do {
                j--;
            } while (j>=0 && ar[j] % 2 != 0);
            if (i>=j) return;
            Swap.swapArray(ar,i,j);
        }
    }
    public static void sortingTwoTypesOfElementsOfBinaryArray(int[]ar) {
        int i = -1;
        int j = ar.length;
        while (true) {
            do {
                i++;
            } while (i<ar.length && ar[i] == 0);
            do {
                j--;
            } while (j>=0 && ar[j] == 1);
            if (i>=j) return;
            Swap.swapArray(ar,i,j);
        }
    }

}
