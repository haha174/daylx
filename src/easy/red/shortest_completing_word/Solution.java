package easy.red.shortest_completing_word;

/**
 * 给定一个字符串牌照 licensePlate 和一个字符串数组 words ，请你找出并返回 words 中的 最短补全词 。
 * <p>
 * 如果单词列表（words）中的一个单词包含牌照（licensePlate）中所有的字母，那么我们称之为 补全词 。在所有完整词中，最短的单词我们称之为 最短补全词 。
 * <p>
 * 单词在匹配牌照中的字母时要：
 * <p>
 * 忽略牌照中的数字和空格。
 * 不区分大小写，比如牌照中的 "P" 依然可以匹配单词中的 "p" 字母。
 * 如果某个字母在牌照中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。
 * 例如：licensePlate = "aBc 12c"，那么它由字母 'a'、'b' （忽略大写）和两个 'c' 。可能的 补全词 是 "abccdef"、"caaacab" 以及 "cbca" 。
 * <p>
 * 题目数据保证一定存在一个最短补全词。当有多个单词都符合最短补全词的匹配条件时取单词列表中最靠前的一个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-completing-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] data = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                data[c - 'a']++;
            } else if (c >= 'A' && c <= 'Z') {
                data[c - 'A']++;
            }
        }
        String result = null;
        for (String s : words) {
            if (isContains(data, s)) {
                if (result == null || s.length() < result.length()) {
                    result = s;
                }
            }
        }
        return result;

    }

    private boolean isContains(int[] license, String word) {
        int[] ans = new int[26];
        for (char c : word.toCharArray()) {
            if (c >= 'a' && c <= 'z')
                ans[c - 'a']++;
            else if (c >= 'A' && c <= 'Z')
                ans[c - 'A']++;
        }

        for (int i = 0; i < 26; i++)
            if (ans[i] < license[i])
                return false;
        return true;
    }
}