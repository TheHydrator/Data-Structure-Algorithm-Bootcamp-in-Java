package G1;

public class FloodFill {

    public int[][] floodFill(int[][]image, int sr, int sc, int newColor){
        int iniColor = image[sr][sc];
        int[][] ans = image;
        int[] delRow = {-1, 0, 1, 0};
        int [] delCol = {0, 1, 0, -1};

        dfs(sr, sc, ans, image, newColor, delRow, delCol, iniColor);
        return ans;
    }

    private void dfs(int row, int col, int[][] ans, int[][] image, int newColor, int[] delRow, int[] delCol, int iniColor) {
        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;
        for (int i = 0; i < 4; i++) {
            int neighRow = row + delRow[i];
            int neighCol = col + delCol[i];
            if(neighRow >= 0 && neighRow < n && neighCol >= 0 && neighCol < m
                    && image[neighRow][neighCol] == iniColor && ans[neighRow][neighCol] != newColor){
                dfs(neighRow, neighCol, ans, image, newColor, delRow, delCol, iniColor);
            }
        }
    }
}
