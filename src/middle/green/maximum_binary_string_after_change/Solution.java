package middle.green.maximum_binary_string_after_change;

class Solution {
    public String maximumBinaryString(String binary) {
        char[] chars = binary.toCharArray();
        int length = chars.length;
        int[] z = new int[length];
        int j = 0;
        //记录0的位置
        for (int i = 0; i < length; i++) {
            if (chars[i] == '0') {
                z[j++] = i;
            }
        }


        for (int i = 0; i < j - 1; i++) {
            //00->10
            if (z[i] + 1 == z[i + 1]) {
                chars[z[i]] = '1';
            } else {
                // 0111……10可以直接变1011……11
                chars[z[i]] = '1';
                // 和后面一位做置换
                chars[z[i + 1]] = '1';
                // 变成 10 记录
                z[i + 1] = z[i] + 1;
                chars[z[i + 1]] = '0';// 0记录变更
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println( new Solution().maximumBinaryString("000110"));
       ;
    }
}
