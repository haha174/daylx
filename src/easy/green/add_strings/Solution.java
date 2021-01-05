package easy.green.add_strings;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 * 通过次数89,117提交次数171,849
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    //    public String addStrings(String num1, String num2) {
//        if (num1==null || num1.length()==0) return num2;
//        if (num2==null || num2.length()==0) return num1;
//        if (num1.length()<num2.length()){
//            String b=num2;
//            num2=num1;
//            num1=b;
//        }
//
//        StringBuilder sb=new StringBuilder();
//        char[] num1Array=num1.toCharArray();
//        char[] num2Array=num2.toCharArray();
//        int c_c=0;
//        for (int i=0;i<num2Array.length;i++){
//            int tempSum=num2Array[num2Array.length-i-1]+ num1Array[num1Array.length-i-1]-96+c_c;
//            sb.append(tempSum%10);
//            c_c=tempSum/10;
//        }
//
//        for (int i=num1Array.length-num2Array.length-1;i>=0;i--){
//            if (c_c>0){
//                int tempSum=num1Array[i]-48+c_c;
//                sb.append(tempSum%10);
//                c_c=tempSum/10;
//            }else {
//                sb.append(num1Array[i]);
//            }
//        }
//        if (c_c>0){
//            sb.append(c_c);
//        }
//        return sb.reverse().toString();
//    }
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) {
                carry += num1.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                carry += num2.charAt(j) - '0';
                j--;
            }
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "199";
        String num2 = "1";
        System.out.println(new Solution().addStrings(num1, num2));
    }
}