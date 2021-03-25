package easy.green.x_of_a_kind_in_a_deck_of_cards;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 给定一副牌，每张牌上都写着一个整数。
 *
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * 示例 2：
 *
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 3：
 *
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 4：
 *
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 * 示例 5：
 *
 * 输入：[1,1,2,2,2,2]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 *
 * 提示：
 *
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length<=1) return false;
        Map<Integer,Integer> map=new HashMap<>();
        int max=0;
        for (int i=0;i<deck.length;i++){
            int temp=map.getOrDefault(deck[i],0)+1;
            if (temp>max){
                max=temp;
            }
            map.put(deck[i],temp);
        }
        for(int key=2;key<=max;key++){
            boolean flag=true;
            Iterator<Integer> iteValue=  map.values().iterator();
            while (iteValue.hasNext()){
                if (iteValue.next()%key!=0){
                    flag=false;
                    break;
                }
            }
            if (flag==true){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] data={1,1};
        System.out.println(new Solution().hasGroupsSizeX(data));
    }
}