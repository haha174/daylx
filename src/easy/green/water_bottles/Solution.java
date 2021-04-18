package easy.green.water_bottles;

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int result=numBottles;
        int leftBottles=numBottles;
        while (leftBottles>=numExchange){
            int exchangeBottles=leftBottles/numExchange;
            result+=exchangeBottles;
            leftBottles=exchangeBottles+leftBottles%numExchange;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numWaterBottles(9,3));
    }
}