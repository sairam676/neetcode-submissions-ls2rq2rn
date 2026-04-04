class Solution {
    int m, n;
    int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        // Step 1: mark border-connected 'O'
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(i, 0, board);
            if (board[i][n - 1] == 'O') dfs(i, n - 1, board);
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') dfs(0, j, board);
            if (board[m - 1][j] == 'O') dfs(m - 1, j, board);
        }

        // Step 2: flip and restore
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';   // surrounded
                else if (board[i][j] == '#') board[i][j] = 'O'; // safe
            }
        }
    }

    private void dfs(int r, int c, char[][] board) {
        if (r < 0 || c < 0 || r >= m || c >= n || board[r][c] != 'O') return;

        board[r][c] = '#';

        for (int[] d : dir) {
            dfs(r + d[0], c + d[1], board);
        }
    }
}