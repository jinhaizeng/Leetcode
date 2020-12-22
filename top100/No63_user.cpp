class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (row ==0 || col == 0) {
            return 0;
        }
        int[][] minPath = new int[row][col];
        minPath[0][0] = grid[0][0];
        for (int i = 1; i < row; ++i) {
            minPath[i][0] = grid[i][0] + minPath[i-1][0]; 
        }
        for (int j = 1; j < col; ++j) {
            minPath[0][j] = grid[0][j] + minPath[0][j-1];
        }
        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < col; ++j) {
                minPath[i][j] = Math.min(minPath[i-1][j], minPath[i][j-1]) + grid[i][j];
            }
        }
        return minPath[row-1][col-1];
    }
}