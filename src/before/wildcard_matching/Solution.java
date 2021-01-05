package before.wildcard_matching;

public class Solution {
    public boolean isMatch(String s, String p) {
        int pLen = p.length();
        int sLen = s.length();

        if(pLen == 0)
            return sLen == 0;

        int i = 0, j = 0, indexPat = -1, indexTex = -1;

        while(i < sLen)
        {
            //simple case
            if(j < pLen && s.charAt(i) == p.charAt(j))
            {
                i++;
                j++;
            }
            else if(j < pLen && p.charAt(j) == '?')  //second base case
            {
                i++;
                j++;
            }
            else if(j < pLen && p.charAt(j) == '*')  // complicated case for *
            {
                //keep i as it is and only increment j as it can mean empty characeter also and store the indexes if it does not mean empty
                indexTex = i;
                indexPat = j;
                j++;
                // 这里为社么不让i 自加是因为   会出现  匹配 空值的情况
            }
            else if(indexPat != -1)
            {
                // 遇到后面不相等的重置j 的值
                j = indexPat + 1;
                 indexTex++;
                i = indexTex;
            }
            else
                return false;
        }

        while(j < pLen && p.charAt(j) == '*')
            j++;

        if(j == pLen)
            return true;

        return false;
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println( s.isMatch("adceb","*a*b"));
    }
}