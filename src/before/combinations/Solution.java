package before.combinations;


import java.util.ArrayList;
import java.util.List;

/**
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */


class Solution {
    static int count=1;
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();

        generateCombinations(answer, new ArrayList<>(), n, k, 1);

        return answer;
    }

    private void generateCombinations(List<List<Integer>> answer,
                                      List<Integer> curr,
                                      int n,
                                      int k,
                                      int j) {
        System.out.println(count++);

        if (k == 0) {
            answer.add(new ArrayList<>(curr));
        } else {
            //3*3
            for (int i = j; i <= n - k + 1; i++) {
                curr.add(i);
                generateCombinations(answer, curr, n, k - 1, i + 1);
                curr.remove(curr.size() - 1);
            }
        }

    }
//
//
//    private void generateCombinations(List<List<Integer>> answer,
//                                      List<Integer> curr,
//                                      int n,
//                                      int k,
//                                      int j) {
//        System.out.println(count++);
//
//        if (k == curr.size()) {
//            answer.add(new ArrayList<>(curr));
//        } else {
//            //3*3
//            for (int i = j; i <= n ; i++) {
//                curr.add(i);
//                generateCombinations(answer, curr, n, k , i + 1);
//                curr.remove(curr.size() - 1);
//            }
//        }
//
//    }
    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 2));
        ;
    }
}