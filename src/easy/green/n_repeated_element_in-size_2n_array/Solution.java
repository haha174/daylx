//
//class Solution {
//    public int repeatedNTimes(int[] A) {
//        for (int i = 0; i < A.length - 1; ++i)
//            if ((A[i] ^ A[i + 1])==0) return A[i];
//        if (A[0] == A[2] || A[0] == A[3]) return A[0];
//        return A[1];
//    }
//}