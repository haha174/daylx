package easy.green.remove_palindromic_subsequences;

// 贪心算法 每次找到开始index 的最长回文串
class Solution {
    //https://leetcode-cn.com/problems/remove-palindromic-subsequences/solution/nao-jin-ji-zhuan-wan-qi-fei-by-yehongzhi/
    public int removePalindromeSub(String s) {
    if ("".equals(s)) return 0;
    if (s.equals(new StringBuilder(s).reverse().toString())) return 1;
    return 2;
}



    public static void main(String[] args) {
        System.out.println(new Solution().removePalindromeSub("abb"));
    }
}