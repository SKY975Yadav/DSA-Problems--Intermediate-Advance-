public class EquilibriumPoint {
    public static void main(String[] args) {
//        int [] ar ={-2,15,12,6,2,5};
//        System.out.println(isEquilibrium(ar,ar.length));

        int [] ar = {2,4,3};
        System.out.println(isThreePartition(ar,ar.length));

    }
    public static boolean isEquilibrium(int [] arr ,int n){
        int rightSum = 0;
        for (int i = 0; i < n; i++) {
            rightSum += arr[i];
        }
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            rightSum -= arr[i];
            if (leftSum==rightSum) return true;
            leftSum += arr[i];
        }
        return false;
    }
    public static boolean isThreePartitions(int [] arr ,int n ){ // O(n^2)
        int [] preFixSum = new int[n];
        preFixSum[0] = arr[0];
        for (int i = 1;i<n;i++){
            preFixSum[i] = preFixSum[i-1]+arr[i];
        }
        int identity ;
        for (int i = 0; i < n; i++) {
            identity = preFixSum[i];
            int noOfGroups = 1;
            for (int j = i+1; j < n; j++) {
                if (preFixSum[j] % identity == 0){
                    noOfGroups++;
                }
                if (noOfGroups==3){
                    return j == n - 1;
                }
            }
        }
        return false;
    }
    public static boolean isThreePartition(int[] arr, int n) {//O(n)
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        if (totalSum % 3 != 0) {
            return false; // Total sum is not divisible by 3
        }

        int partitionSum = totalSum / 3;
        int currentSum = 0;
        int partitionsFound = 0;

        for (int i = 0; i < n - 1; i++) {
            currentSum += arr[i];
            if (currentSum == partitionSum * (partitionsFound + 1)) {
                partitionsFound++;
            }
            if (partitionsFound == 2) {
                return true;
            }
        }
        return false;
    }

}
