package easy.green.find_lucky_integer_in_an_array;

class Solution {
    public int findLucky(int[] arr) {
        int[] temp = new int[501];
        // 将出现次数存入计数器
        for (int i : arr) {
            temp[i]++;
        }

        // 倒叙便利计数器中的值, 若下标的值 == 出现的次数, 则直接返回即可(此时即为最大值)
        for (int i = temp.length - 1; i >= 1; i--) {
            if (i == temp[i]) {
                return i;
            }
        }

        // 说明没有幸运数
        return -1;
    }
}

