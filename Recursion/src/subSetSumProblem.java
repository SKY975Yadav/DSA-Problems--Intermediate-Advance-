public class subSetSumProblem {
    public static void main(String[] args) {
        int [] arr = {10,20,15};
        System.out.println(countSubSetSum(arr,3,25));
        System.out.println(temp);
    }
    //Subset of of set / array whose sum is equals to given sum . WE have to return the no.of subsets
    static int temp = 0;
    static int countSubSetSum(int [] arr,int n ,int sum){
        temp++;
        if (sum<0) return 0;
        if (n==0)
            return (sum==0)?1:0;
        return countSubSetSum(arr,n-1,sum) + countSubSetSum(arr,n-1,sum-arr[n-1]);
    }
}
