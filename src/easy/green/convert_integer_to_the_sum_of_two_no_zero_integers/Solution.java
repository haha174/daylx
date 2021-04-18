package easy.green.convert_integer_to_the_sum_of_two_no_zero_integers;

class Solution {
    public int[] getNoZeroIntegers(int n) {
        int a = n / 2;
        int[] result = new int[2];
        while (a > 0) {
            int b = n - a;
            if (String.valueOf(a).indexOf('0') < 0 && String.valueOf(b).indexOf('0') < 0) {
                result[0] = a;
                result[1] = b;
                break;
            }
            a--;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getNoZeroIntegers(10000));
    }
}