public class MatrixBoundaryTraversal {
    public static void main(String[] args) {
        int [][] mulArr =
                {       {1,2,3,4,5},
                        {6,7,8,9,10},
                        {11,12,13,14,15},
                        {16,17,18,19,20}
                };
        boundaryTraversal(mulArr, mulArr.length, mulArr[0].length);
    }
    static void boundaryTraversal(int [][] arr,int m,int n){
        if (m==1){
            for (int i = 0; i < n; i++) {
                System.out.print(arr[0][i]+" ");
            }
        }
        if (n==1){
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i][0]+" ");
            }
        }
        else {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[0][i]+" ");
            }
            for (int i = 1; i < m; i++) {
                System.out.print(arr[i][n-1]+" ");
            }
            for (int i = n-2; i >=0; i--) {
                System.out.print(arr[m-1][i]+" ");
            }
            for (int i = m-2; i >0 ; i--) {
                System.out.print(arr[i][0]+" ");
            }
        }
    }
}
