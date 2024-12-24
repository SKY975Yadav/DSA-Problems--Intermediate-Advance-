import java.util.ArrayList;

public class ReverseSubArrayByK {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(15);
        al.add(25);
        al.add(35);
        al.add(45);
        al.add(55);
        al.add(65);
        al.add(75);
        al.add(85);
        al.add(95);
        al.add(105);
        System.out.println(al);
        reverseInGroups(al,3);
        System.out.println(al);
    }
    static void reverseInGroups(ArrayList<Integer> arr, int k) {
        // code here
        int first = 0;
        for(int i = k; i< arr.size(); i += k){
            reverse(arr,first,i-1);
            first = i;
        }
        reverse(arr,first,arr.size()-1);
    }
    static void reverse(ArrayList<Integer> arr, int low, int high){
        while(low<high){
            arr.set(low, (arr.get(low) + arr.get(high)) -  (arr.get(high) - arr.set(high, arr.get(low)) + arr.get(high))  );
            low++;
            high--;
        }
    }
}
