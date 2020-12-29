class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }

        int row = board.length;
        int col = board[0].length;
        char[] sub = word.toCharArray();
        boolean result = false;
        for (int i=0; i < row; ++i) {
            for (int j=0; j < col; ++j) {
                int[][] visit = new int[row][col];
                result = search(board, sub, 0, i, j, visit);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, char[] sub, int index, int i, int j, int[][] visit) {
        
        if (index > sub.length -1 || i < 0 || i > board.length -1 || j < 0 || j > board[0].length -1 || visit[i][j] == 1) {
            return false;
        }

        boolean result = false;
        if (sub[index] == board[i][j]) {
            //System.out.println("i: " + i + "j: " + j);
            visit[i][j] = 1;
            if (index == sub.length - 1) {
                return true;
            }
            result = search(board, sub, index + 1, i + 1, j, visit);
            if (result) {
                return true;
            }
            result = search(board, sub, index + 1, i - 1, j, visit);
            if (result) {
                return true;
            }
            result = search(board, sub, index + 1, i, j + 1, visit);
            if (result) {
                return true;
            }
            result = search(board, sub, index + 1, i, j - 1, visit);
            if (result) {
                return true;
            }
            //沙雕，这类递归都是要回归状态的
            visit[i][j] = 0;
        }
        return false;
    }
}