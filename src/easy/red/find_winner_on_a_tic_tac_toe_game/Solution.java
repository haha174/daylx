package easy.red.find_winner_on_a_tic_tac_toe_game;

class Solution {
    public String tictactoe(int[][] moves) {
        // a, b record the moving results of A, B
        int a = 0, b = 0, len = moves.length;
        // ac records all cases of winning
        int[] ac = {7, 56, 448, 73, 146, 292, 273, 84};
        for(int i = 0; i < len; i ++){
            // if i is add
            if((i & 1) == 1){
                // record the step result
                b ^= 1 << (3 * moves[i][0] + moves[i][1]);
            }
            else {
                a ^= 1 << (3 * moves[i][0] + moves[i][1]);
            }
        }
        for(int i : ac){
            // if the moving result contains the winning case in record, then win
            if((a & i) == i){
                return "A";
            }
            if((b & i) == i){
                return "B";
            }
        }
        // or judge the result by the amount of steps
        return len == 9 ? "Draw" : "Pending";
    }

}