/*
Given a grid of size n*n filled with 0, 1, 2, 3. Check whether there is a path possible from the source to destination. You can traverse up, down, right and left.
The description of cells is as follows:

A value of cell 1 means Source.
A value of cell 2 means Destination.
A value of cell 3 means Blank cell.
A value of cell 0 means Wall (blocked cell which we cannot traverse).
Note: There are only a single source and a single destination.


Examples :

Input: grid = {{3,0,3,0,0},{3,0,0,0,3},{3,3,3,3,3},{0,2,3,0,0},{3,0,0,1,3}}
Output: 0
Explanation: The grid is-
3 0 3 0 0
3 0 0 0 3
3 3 3 3 3
0 2 3 0 0
3 0 0 1 3
There is no path to reach at (3,1) i,e at destination from (4,3) i,e source.
Input: grid = {{1,3},{3,2}}
Output: 1
Explanation: The grid is-
1 3
3 2
There is a path from (0,0) i,e source to (1,1) i,e destination.
Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(n2)


Constraints:
1 ≤ n ≤ 500


 */

public class FindWhetherPathExistOrNot {
    public static void main(String[] args) {

    }
    //Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid)
    {
        // Code here
        int startX = -1,startY=-1,n = grid.length,m = grid[0].length;
        boolean [][] visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    startX = i;
                    startY = j;
                    break;
                }
            }
        }
        return dfs(grid,visited,startX,startY,n,m);

    }
    private boolean dfs(int [][]grid,boolean [][] visited,int x,int y,int n,int m){

        if(x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0 || visited[x][y]) return false;

        visited[x][y] = true;

        if(grid[x][y] == 2) return true;


        int [] dx = {-1,1,0,0};
        int [] dy = {0,0,-1,1};

        for(int k=0;k<4;k++){
            if(dfs(grid,visited, x+dx[k], y+dy[k], n, m)){
                return true;
            }
        }
        return false;
    }
}
