class Solution {
    public int uniquePaths(int m, int n) {
        int[][] location = new int [m][n];
        for (int i=0; i < m; ++i) {
            location[i][0] = 1;
        }
        for (int j=0; j < n; ++j) {
            location[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                location[i][j] = location[i-1][j] + location[i][j-1];
            }
        }
        return location[m-1][n-1];
    }
}