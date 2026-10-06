//problem link : https://leetcode.com/problems/flood-fill/description/
//problem name : Flood Fill Algorithm.

//Solution with time complexity of O(m × n) and space complexity O(m × n).

package Graphs;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int oldcolor = image[sr][sc];

        if(oldcolor == color){
            return image;
        }

        dfs(image , sr , sc , oldcolor , color);

        return image;
    }

    public void dfs(int[][] image , int row , int col , int oldcolor , int color){

        if(row < 0 || row >= image.length || col < 0 || col >= image[0].length){
            return;
        }

        if(image[row][col] != oldcolor){
            return;
        }

        image[row][col] = color;

        dfs(image , row-1 , col , oldcolor , color);

        dfs(image , row+1 , col , oldcolor , color);

        dfs(image , row , col-1 , oldcolor , color);

        dfs(image , row , col+1 , oldcolor , color);
    }
}
