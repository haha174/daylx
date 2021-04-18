package easy.green.maximum_score_after_splitting_a_string;

class Solution {
    public int maxScore(String s) {
        int res = 0, cnt1 = 0, cnt0 = 0;        //cnt1统计右边1的个数，同理cnt0左边0的个数
        for(int i = 0; i < s.length(); i++){
            cnt1 += s.charAt(i)-'0';            //先统计1的个数
        }                                       //由于左右区域的数至少为1，所以i不能等于len-1
        for(int i = 0; i < s.length()-1; i++){  //点i分为左右两个区域        
            if(s.charAt(i) == '0') cnt0++;      //遇到01就统计，动态更新左右区域01个数
            else cnt1--;
            res = Math.max(res, cnt0+cnt1);
        }
        return res;
    }
}
