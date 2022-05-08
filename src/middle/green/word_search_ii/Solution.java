package middle.green.word_search_ii;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for (int k = 0; k < words.length; k++) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == words[k].charAt(0)) {
                        if (exist(board, words[k], i, j, 0)) {
                            result.add(words[k]);
                            j=board[0].length;
                            i=board.length;
                        }
                    }
                }
            }
        }
        return result;
    }

    public boolean exist(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length) return false;
        if (j < 0 || j >= board[0].length) return false;
        if (word.charAt(index) != board[i][j]) return false;
        char current = board[i][j];
        board[i][j] = '0';
        boolean cResult = exist(board, word, i - 1, j, index + 1)
                || exist(board, word, i + 1, j, index + 1)
                || exist(board, word, i, j - 1, index + 1)
                || exist(board, word, i, j + 1, index + 1);
        board[i][j] = current;
        return cResult;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String[] word = {"SEE"};
        System.out.println(new Solution().findWords(board, word));
    }
}