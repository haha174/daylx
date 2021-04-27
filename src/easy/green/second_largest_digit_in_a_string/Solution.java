package easy.green.second_largest_digit_in_a_string;

class Solution {
    public int secondHighest(String s) {
        int MAX=-1;
        int SecondMAX=-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){//判断是否为数字
                if(s.charAt(i)-'0'>MAX){//最大值，第二大值更新
                    
                    SecondMAX=MAX;
                    MAX=s.charAt(i)-'0';
                }
                else if(s.charAt(i)-'0'>SecondMAX&&s.charAt(i)-'0'<MAX)//小于最大值但大于第二大的值，更新第二大的值
                {
                    SecondMAX=s.charAt(i)-'0';
                }
            }
        }
        if(MAX==SecondMAX||SecondMAX==-1)//串中没有数字或只有一个数字
            return -1;
        return SecondMAX;
    }
}
