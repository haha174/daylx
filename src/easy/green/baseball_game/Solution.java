package easy.green.baseball_game;

import java.util.ArrayList;
import java.util.List;

/**
 * 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
 * <p>
 * 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
 * <p>
 * 整数 x - 表示本回合新获得分数 x
 * "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
 * "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * 请你返回记录中所有得分的总和。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/baseball-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int calPoints(String[] ops) {
        List<Integer> temp = new ArrayList<>();
        for (String str : ops) {
            if (str.equals("C")) {
                temp.remove(temp.size() - 1);
            } else if (str.equals("D")) {
                temp.add(temp.get(temp.size() - 1) * 2);
            } else if (str.equals("+")) {
                temp.add(temp.get(temp.size() - 1) + temp.get(temp.size() - 2));
            } else {
                temp.add(Integer.parseInt(str));
            }
        }
        int result = 0;
        for (Integer in : temp) {
            result += in;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] data= {"5","2","C","D","+"};
        System.out.println(new Solution().calPoints(data));
    }
}