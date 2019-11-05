package plus_one;


class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return digits;
        }
        int n = digits.length;
        int carry_num = 1;
        for (int i = n - 1; i >= 0; i--) {
            int temp = (digits[i] + carry_num) % 10;
            carry_num = (digits[i] + carry_num) / 10;
            digits[i] = temp;
        }
        if (carry_num > 0) {
            int[] result = new int[n + 1];
            result[0] = carry_num;
            for (int i = 1; i <= n; i++) {
                result[i] = digits[i - 1];
            }
            return result;

        }
        return digits;
    }

    public static void main(String[] args) {
        int[] data = {9};
        int[] result = new Solution().plusOne(data);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}