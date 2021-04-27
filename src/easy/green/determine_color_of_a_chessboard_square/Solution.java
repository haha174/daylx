package easy.green.determine_color_of_a_chessboard_square;

class Solution {
    public boolean squareIsWhite(String coordinates) {
        char z=coordinates.charAt(0);
        char s=coordinates.charAt(1);
        if((z-97+1)%2 !=0){
            if((s-48)%2 !=0){
                return false;
            }else{
                return true;
            }
        }else{
            if((s-48)%2 !=0){
                return true;
            }else{
                return false;
            }
        }
    }
}
