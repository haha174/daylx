package easy.red.complement_of_base_10_integer;

class Solution {
    public int bitwiseComplement(int N) {
        if(N==0){
            return 1;
        }
        int num=1;
        while(num<=N){
            num<<=1;
        }
        return num-1-N;
    }
}

