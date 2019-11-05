package add_binary;

class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        StringBuilder sb = new StringBuilder();
        char[] dataA = a.toCharArray();
        char[] dataB = b.toCharArray();
        int m = dataA.length - 1;
        int n = dataB.length - 1;
        int index = 0;
        int carry_num = 0;

        while (index <= m && index <= n) {
            int temp = dataA[m - index]-48 + dataB[n - index]-48 + carry_num;
            sb.append(temp % 2);
            carry_num = temp / 2;
            index++;
        }
        if (index <= m) {
            while (index <= m) {
                int temp = dataA[m - index]-48 + carry_num;
                sb.append(temp % 2);
                carry_num = temp / 2;
                index++;
            }
        } else if (index <= n) {
            while (index <= n) {
                int temp = dataB[n - index]-48 + carry_num;
                sb.append(temp % 2);
                carry_num = temp / 2;
                index++;
            }
        }
        if (carry_num > 0) {
            sb.append(carry_num);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary( "11",  "1"));
    }
}