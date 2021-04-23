package easy.green.make_the_string_great;

class Solution {
    public String makeGood(String s) {
        boolean flag = true;
        while (flag) {
            flag = false;
            char[] data = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            int i = 1;
            for (; i < data.length; i++) {
                if (data[i] != data[i - 1] - 32 && data[i] - 32 != data[i - 1]) {
                    sb.append(data[i - 1]);
                } else {
                    i++;
                    flag = true;
                }
            }
            if (i == data.length) {
                sb.append(data[data.length - 1]);
            }
            s = sb.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().makeGood("leEeetcode"));
    }
}