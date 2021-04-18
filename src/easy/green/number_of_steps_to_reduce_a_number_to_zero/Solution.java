package easy.green.number_of_steps_to_reduce_a_number_to_zero;

class Solution {
    public int numberOfSteps (int num) {
        int tmp =0;
        while(num>0){
            if(num % 2 ==0){
                num=num/2;
                tmp++;
            }else{
                num =num-1;
                tmp++;
            }
        }
        return tmp;
    }
}
