package middle.red.word_search;

class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]==word.charAt(0) &&  exist( board,  word, i, j, 0)){
                   return true;
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word,int i,int j,int index) {
        if (i<0 || i>=board.length || j<0 || j>= board[0].length || board[i][j]!=word.charAt(index)){
            return false;
        }
        if (index==word.length()-1){
            return true;
        }
        char t=board[i][j];
        board[i][j]='0';
        boolean flag=exist(board,  word, i-1, j, index+1)
                ||exist(board,  word, i, j-1, index+1)
                ||exist(board,  word, i+1, j, index+1)
                ||exist(board,  word, i, j+1, index+1)
                ;
        board[i][j]=t;
        return flag;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "SEE";
        System.out.println(new Solution().exist(board, word));
    }
}