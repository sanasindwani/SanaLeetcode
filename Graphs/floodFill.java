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

