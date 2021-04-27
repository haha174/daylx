package easy.green.minimum_changes_to_make_alternating_binary_string;

class Solution {
    public int minOperations(String s) {
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < s.length(); i++) {
            if(i % 2 == 0){
                if(s.charAt(i) != '0')
                    cnt1++;
                if(s.charAt(i) != '1')
                    cnt2++;
            }else {
                if(s.charAt(i) != '1')
                    cnt1++;
                if(s.charAt(i) != '0')
                    cnt2++;
            }
        }
        return Math.min(cnt1,cnt2);
    }
}
