public class TheCelebrityProblem {
    public static void main(String[] args) {
        int[][] M = {{0, 1, 0},
            {0, 0 ,0},
            {0 ,1 ,0}};
        System.out.println(celebrity(M,M.length));
    }
    /*
    A celebrity is a person who is known to all but does not know anyone at a party. If you go to a party of N people, find if there is a celebrity in the party or not.
A square NxN matrix M[][] is used to represent people at the party such that if an element of row i and column j  is set to 1 it means ith person knows jth person. Here M[i][i] will always be 0.
Return the index of the celebrity, if there is no celebrity return -1.
Note: Follow 0 based indexing.
Follow Up: Can you optimize it to O(N)


Example 1:

Input:
N = 3
M[][] = {{0 1 0},
         {0 0 0},
         {0 1 0}}
Output: 1
Explanation: 0th and 2nd person both
know 1. Therefore, 1 is the celebrity.

Example 2:

Input:
N = 2
M[][] = {{0 1},
         {1 0}}
Output: -1
Explanation: The two people at the party both
know each other. None of them is a celebrity
     */

    static int celebrity(int[][] M, int n)
    {
        // code here
        // Find the candiate , he might be celebrity
        int candiate = 0;
        for(int i = 1 ; i< n ;i++){
            if(M[candiate][i] == 1){
                candiate = i;
            }
        }

        for(int i = 0 ; i < n ; i++){
            if(i!=candiate){
                if(M[candiate][i]==1 || M[i][candiate]==0){
                    return -1;
                }
            }
        }
        return candiate;
    }
}
