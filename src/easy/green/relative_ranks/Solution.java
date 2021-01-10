package easy.green.relative_ranks;

/**
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
 *
 * (注：分数越高的选手，排名越靠前。)
 *
 * 示例 1:
 *
 * 输入: [5, 4, 3, 2, 1]
 * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
 * 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
 * 提示:
 *
 * N 是一个正整数并且不会超过 10000。
 * 所有运动员的成绩都不相同。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-ranks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public String[] findRelativeRanks(int[] nums) {
        String[] result=new String[nums.length];
        int maxLength=-1;
        for (int i=0;i<nums.length;i++){
            if (nums[i]>maxLength){
                maxLength=nums[i];
            }
        }
        int[] data=new int[maxLength+1];
        for (int i=0;i<=maxLength;i++){
            data[i]=-1;
        }
        for (int i=0;i<nums.length;i++){
            data[nums[i]]=i;
        }
        int c_c=1;
        for (int i=maxLength;i>=0;i--){
            if (data[i]!=-1){
                if (c_c==1){
                    result[ data[i]]="Gold Medal";
                }else if (c_c==2){
                    result[ data[i]]="Silver Medal";
                }else if (c_c==3){
                    result[ data[i]]="Bronze Medal";

                }else{
                    result[ data[i]]=c_c+"";
                }
                c_c++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={5,4,3,2,1,0};
        System.out.println(new Solution().findRelativeRanks(nums));
    }
}