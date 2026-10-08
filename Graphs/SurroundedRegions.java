//problem link : https://leetcode.com/problems/surrounded-regions/description/
//problem name : Surrounded Regions.

//Solution with time complexity of O(n × m) and space complexity O(n × m).

package Graphs;

class Solution {

    int[] dr = {-1 , 1 , 0 , 0};
    int[] dc = {0 , 0 , -1 , 1};

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int j=0 ; j<m ; j++){
            if(board[0][j] == 'O'){
                dfs(board , 0 , j);
            }
            if(board[n-1][j] == 'O'){
                dfs(board , n-1 , j);
            }
        }

        for(int i=0 ; i<n ; i++){
            if(board[i][0] == 'O'){
                dfs(board , i , 0);
            }
            if(board[i][m-1] == 'O'){
                dfs(board , i , m-1);
            }
        }

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    void dfs(char[][] board , int i , int j){

        int n = board.length;
        int m = board[0].length;

        if(i < 0 || i >= n || j < 0 || j >= m){
            return;
        }

        if(board[i][j] != 'O'){
            return;
        }

        board[i][j] = '#';

        for(int k=0 ; k<4 ; k++){
            int newRow = i + dr[k];
            int newCol = j + dc[k];

            dfs(board , newRow , newCol);
        }
    }
}
