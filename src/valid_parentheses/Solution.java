package valid_parentheses;

/**
 * 用栈实现
 * https://leetcode.com/problems/valid-parentheses/
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */
class Solution {
    public boolean isValid(String s) {
        char[] brackets = new char[s.length()];
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                brackets[++top] = c;
            } else if (top < 0) {
                return false;
            } else if (c == ')' && brackets[top] == '(' || c == '}' && brackets[top] == '{'
                    || c == ']' && brackets[top] == '[') {
                top--;
            } else {
                return false;
            }
        }
        if (top >= 0) {
            return false;
        }
        return true;
    }
}