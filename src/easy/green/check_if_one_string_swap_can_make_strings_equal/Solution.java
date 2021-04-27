package easy.green.check_if_one_string_swap_can_make_strings_equal;

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        String s1_diff = "";
        String s2_diff = "";
        for (int i = 0;i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                s1_diff += s1.charAt(i);
                s2_diff = s2.charAt(i) + s2_diff;
                if (s1_diff.length() > 2) {
                    return false;
                }
            }
        }
        return (s1_diff.length() == 2) && (s1_diff.equals(s2_diff));
    }
}
