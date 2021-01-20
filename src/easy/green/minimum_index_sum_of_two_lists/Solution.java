package easy.green.minimum_index_sum_of_two_lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * <p>
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 * 示例 2:
 * <p>
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
//    public String[] findRestaurant(String[] list1, String[] list2) {
//        List<String> list = new ArrayList<>();
//        if (list1.length == 0 || list2.length == 0) return new String[0];
//        int minIndex = Integer.MAX_VALUE;
//        for (int i = 0; i < list1.length; i++) {
//            for (int j = 0; j < list2.length; j++) {
//                if (list1[i].equals(list2[j])) {
//                    if (i + j > minIndex) {
//                        continue;
//                    }
//                    if (i + j < minIndex) {
//                        minIndex = i + j;
//                        list.clear();
//                    }
//                    list.add(list1[i]);
//                    break;
//                }
//            }
//        }
//        return list.toArray(new String[list.size()]);
//    }


    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> list = new ArrayList<>();
        if (list1.length == 0 || list2.length == 0) return new String[0];
        if (list2.length > list1.length) {
            return findRestaurant(list2, list1);
        } else {
            int minIndex = Integer.MAX_VALUE;
            Map<String, Integer> list1Map = new HashMap<>();
            for (int i = 0; i < list1.length; i++) {
                list1Map.put(list1[i], i);
            }

            for (int i = 0; i < list2.length; i++) {
                Integer j = list1Map.get(list2[i]);
                if (j == null) {
                    continue;
                }
                if (i + j > minIndex) {
                    continue;
                }
                if (i + j < minIndex) {
                    minIndex = i + j;
                    list.clear();
                }
                list.add(list2[i]);
            }
            return list.toArray(new String[list.size()]);
        }
    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        System.out.println(new Solution().findRestaurant(list1, list2));

    }
}