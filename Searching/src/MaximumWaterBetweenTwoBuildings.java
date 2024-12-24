public class MaximumWaterBetweenTwoBuildings {
    public static void main(String[] args) {
        int [] arr = {2,4,8,4,13,6,8,2,18,4,10};
        System.out.println(maxWater(arr, arr.length));
    }
    static int maxWater(int [] height, int n) //Maximum water between any two buildings by removing all buildings between that two buildings
    {
        //Your code here
        if (n <= 2) return 0;

        int left = 0, right = n - 1;
        int maxWater = 0;

        while (left < right) {
            int gap = right - left - 1;
            int minHeight = Math.min(height[left], height[right]);
            maxWater = Math.max(maxWater, gap * minHeight);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}
