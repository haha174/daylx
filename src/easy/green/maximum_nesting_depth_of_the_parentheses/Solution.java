package easy.green.maximum_nesting_depth_of_the_parentheses;

class Solution {
    int maxDepth(String s) {
        int l = 0;
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') l++;
            if (c == ')') l--;
            res = Math.max(res, l);
        }
        return res;
    }
}