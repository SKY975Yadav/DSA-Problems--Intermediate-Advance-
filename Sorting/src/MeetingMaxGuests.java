import java.util.Arrays;

public class MeetingMaxGuests {
    public static void main(String[] args) {
        int [] arr  = {500,1100,800,400};
        int [] des = {600,1200,900,700};

        System.out.println(maxGuest(arr,des, arr.length));
    }

    // meeting max guests TC : O(n log n)
    public static int maxGuest(int[] arr, int[] dep, int n) // Meeting max guests given two two arrays one array contains tine of when they come to party and another array when they leave the party, Idea is simple sort the both arrays and check at a moment how many guests there, Note time 10:20 like we write as 1030
    {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 1, j = 0, res = 1, curr = 1;
        while (i < n && j < n) {
            if (arr[i] < dep[j]) {
                curr++;
                i++;
            } else {
                res = Math.max(curr, res);
                curr--;
                j++;
            }
        }
        return res;
    }
}
