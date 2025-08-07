/*
Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of '0's (Water) and '1's(Land). Find the number of islands.

Note: An island is either surrounded by water or the boundary of a grid and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.

Examples:

Input: grid = [[0,1],[1,0],[1,1],[1,0]]
Output: 1
Explanation:
The grid is-

All lands are connected.
Input: grid = [[0,1,1,1,0,0,0],[0,0,1,1,0,1,0]]
Output: 2
Expanation:
The grid is-

There are two islands :- one is colored in "blue" and other in "red".
Expected Time Complexity: O(n*m)
Expected Space Complexity: O(n*m)

Constraints:
1 ≤ n, m ≤ 500
grid[i][j] = {'0', '1'}
 */
public class NumberOfIslands {
    public static void main(String[] args) {

    }
    public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid,i,j,n,m);
                }
            }
        }
        return count;
    }
    private void dfs(char [][]grid,int x,int y,int n,int m){
        if(x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == '0') return;

        grid[x][y] = '0';

        int [] dx = {-1,1,0,0,-1,-1,1,1};
        int [] dy = {0,0,-1,1,-1,1,-1,1};

        for(int k = 0 ; k<8; k++){
            dfs(grid, x+dx[k], y+dy[k],n,m);
        }
    }
}
