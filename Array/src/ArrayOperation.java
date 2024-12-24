class ArraysOperations{
    public int search(int [] ar, int x){
        for (int i=0;i<ar.length;i++){
            if (ar[i]==x) return i;
        }
        return -1;
    }
    public int insert(int []ar,int pos,int data,int CurrentSize){
        if (ar.length==CurrentSize){
            return CurrentSize;
        }
        int ind = pos-1;
        for (int i=CurrentSize;i>=ind;i--){
            ar[i+1] = ar[i];
        }
        ar[ind] = data;
        return CurrentSize+1;
    }
    public int delete(int[] arr, int n, int x) {//n=currentSize
        int i ;
        for(i = 0; i < n; i++)
        {
            if(arr[i] == x)
                break;
        }
        if(i == n)
            return n;
        for(int j = i; j < n - 1; j++)
            arr[j] = arr[j + 1];
        return n-1;
    }
}
public class ArrayOperation {
    public static void main(String[] args) {
        ArraysOperations ao = new ArraysOperations();
        System.out.println("hfjksdhf");
    }
}
