package convert_a_number_to_hexadecimal;

class Solution {
    public String toHex(int num) {
        String[] HEX = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
        StringBuilder res=new StringBuilder();
        int native_counter = 0;
        if(num == 0)
            return "0";
        while(num!=0 && ++native_counter <=8)
        {
            res.append(HEX[num & 0xf]);
            num = num>>4;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(-2>>4);
        System.out.println(new Solution().toHex(-1));
        ;
    }
}