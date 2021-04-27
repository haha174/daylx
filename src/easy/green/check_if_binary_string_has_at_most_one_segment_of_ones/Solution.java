package easy.green.check_if_binary_string_has_at_most_one_segment_of_ones;

class Solution {
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}
