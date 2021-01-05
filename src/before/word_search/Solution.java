package before.word_search;

/**
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        char[] arr = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (bfs(board, i, j, 0, arr)) return true;
            }
        }

        return false;
    }

    public boolean bfs(char[][] board, int i, int j, int index, char[] word) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '.' || word[index] != board[i][j]) {
            return false;
        }
        if (index == word.length - 1) {
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '.';
        boolean res = bfs(board, i - 1, j, index + 1, word) || bfs(board, i + 1, j, index + 1, word) || bfs(board, i, j - 1, index + 1, word) || bfs(board, i, j + 1, index + 1, word);
        board[i][j] = temp;
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(new Solution().exist(board, "ABCCED"));
        System.out.println(new Solution().exist(board, "SEE"));
        System.out.println(new Solution().exist(board, "ABCB"));

    }
}