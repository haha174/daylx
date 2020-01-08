package pascals_triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 *
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result=new ArrayList<>();
        if (numRows<1){
            return result;
        }
        List<Integer> list=new ArrayList<>();
        list.add(1);
        result.add(list);

        for (int i=1;i<numRows;i++){
            list=result.get(i-1);
            List<Integer> listData=new ArrayList<>();
            listData.add(1);
            for (int j=1;j<i;j++){
                listData.add(list.get(j)+list.get(j-1));
            }
            listData.add(1);
            result.add(listData);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generate(7));
    }
}