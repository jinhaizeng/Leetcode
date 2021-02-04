class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null){
            return 0;
        }

        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i=0; i < row; i++) {
            for(int j=0; j < col; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int x, int y) {
        int row = grid.length;
        int col = grid[0].length;
        if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] == '0') {
            return;
        }
        if (grid[x][y] == '1') {
            grid[x][y] = '0';
        }

        dfs(grid, x-1, y);
        dfs(grid, x+1, y);
        dfs(grid, x, y-1);
        dfs(grid, x, y+1);
    }
}