package easy.green.binary_prefix_divisible_by_5;

import java.util.*;
import java.util.ArrayList;

class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> answer = new ArrayList<Boolean>();
        int prefix = 0;
        int length = A.length;
        for (int i = 0; i < length; i++) {
            prefix = ((prefix << 1) + A[i]) % 5;
            answer.add(prefix == 0);
        }
        return answer;
    }
}
