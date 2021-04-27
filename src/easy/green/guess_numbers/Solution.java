package easy.green.guess_numbers;

class Solution {
    public int game(int[] guess, int[] answer) {
        int tmp =0;
        for(int i=0;i<guess.length;i++){
            if(guess[i] == answer[i]){
                tmp++;
            }
        }
        return tmp;
    }
}

