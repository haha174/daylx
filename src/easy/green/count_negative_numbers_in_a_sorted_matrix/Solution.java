package easy.green.count_negative_numbers_in_a_sorted_matrix;

public class Solution
{
    public int countNegatives(int[][] grid)
    {
        int sum = 0;
        for (int i = 0; i < grid.length; i++)
        {
            //利用二分查找,找到最大的负数的下标!
            int left = 0;
            int right = grid[i].length - 1;
            int temp=grid[i].length;
            sum = sum + right + 1;
            while (left <= right)
            {
                int mid = (left + right) / 2;
                if (grid[i][mid] >= 0)
                {
                    left = mid + 1;
                }
                else
                {
                    temp = mid;
                    right = mid - 1;
                }
            }
            sum = sum - temp;
        }
        return sum;
    }
}
