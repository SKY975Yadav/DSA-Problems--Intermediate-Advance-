import java.util.Arrays;

public class CycleSort {
    public static void main(String[] args) {
        int[] arr = {4, 1, 4, 2, 6, 6, 2, 2, 2, 3, 3, 4, 1, 5, 1};
        System.out.println(Arrays.toString(arr));
        System.out.println(cycleSort(arr, arr.length));
        System.out.println(Arrays.toString(arr));
    }

    public static int cycleSort(int[] arr, int n) {
        int writes = 0;// To count the number of writes

        // Traverse the array to find cycles to rotate
        for (int cycleStart = 0; cycleStart < n - 1; cycleStart++) {

            int pos = cycleStart;
            int item = arr[cycleStart];

            // Find the position where we put the element
            for (int i = cycleStart + 1; i < n; i++) {
                if (arr[i] < item) {
                    pos++;
                }
            }

            if (pos == cycleStart) continue;  // If the element is already in the correct position

            // Otherwise, put the element at its correct position

            while (item == arr[pos]) { // To handle duplicates we just skip those elements
                pos++;
            }
            //Swapping
            int temp = arr[pos];
            arr[pos] = item;
            item = temp;
            writes++;


            // Rotate the rest of the cycle
            while (pos != cycleStart) {
                pos = cycleStart;
                for (int i = cycleStart + 1; i < n; i++) {
                    if (arr[i] < item) {
                        pos++;
                    }
                }
                //To Handle Duplicates
                while (item == arr[pos]) {
                    pos++;
                }

                //Swapping
                temp = arr[pos];
                arr[pos] = item;
                item = temp;
                writes++;
            }
        }
        return writes;
    }
}
