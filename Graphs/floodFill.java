package Graphs;

public class floodFill {
    // mistake -> is color same as def return image otherwise loop will keep on running

    void dfs(int i, int j, int def,int color, int[][] image){
        if(i >= image.length || j >= image[0].length || i < 0 || j < 0) return;
        if(image[i][j] == def){
            image[i][j] = color;
            dfs(i+1, j, def, color, image);
            dfs(i-1, j, def, color, image);
            dfs(i, j+1, def, color, image);
            dfs(i, j-1, def, color, image);
        }
        return;
    }

    public int[][] FloodFill(int[][] image, int sr, int sc, int color) {
        int def = image[sr][sc];
        if(def == color) return image;
        else dfs(sr, sc, def, color, image);
        return image;
    }
}
/* class Solution {
    void dfs(int row, int col, int[][] ans, int[][] image, int[] delX,
    int[] delY, int iniC, int newColor){
        ans[row][col] = newColor;
        int x = ans.length;
        int y = ans[0].length;
        
        for(int i = 0; i < 4; i++){
            int nRow = row + delX[i];
            int nCol = col + delY[i];
            
            if(nRow >= 0 && nRow < x && nCol >= 0 && nCol < y && image[nRow][nCol] == iniC && image[nRow][nCol] != newColor){
                dfs(nRow, nCol, ans, image, delX, delY, iniC, newColor);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // code here
        int iniC = image[sr][sc];
        if(iniC  == newColor) return image;
        int[][] ans = image;
        int[] delX = {1,0,-1,0};
        int[] delY = {0,1,0,-1};
        dfs(sr, sc, ans, image, delX, delY, iniC, newColor);
        return ans;
    }
}*/
