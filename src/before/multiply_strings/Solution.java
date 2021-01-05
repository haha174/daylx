package before.multiply_strings;


public class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        int[] s = new int[n];
        int[] t = new int[m];
        for (int i = 0; i < n; i++) {
            s[i] = num1.charAt(i) - 48;
        }
        for (int i = 0; i < m; i++) {
            t[i] = num2.charAt(i) - 48;
        }

        int[] c = new int[n + m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                c[i + j + 1] += s[i] * t[j];
            }
        }
        for (int i = c.length - 1; i > 0; i--) {
            if (c[i] >= 10) {
                c[i - 1] += c[i] / 10;
                c[i] %= 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < c.length - 1 && c[i] == 0) {
            i++;
        }
        for (; i < c.length; i++) {
            sb.append(c[i]);
        }
        return sb.toString();
    }


    public String multiply1(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int[] c1 = new int[n];
        int[] c2 = new int[m];
        for (int i = 0; i < n; i++) {
            c1[i] = num1.charAt(i) - 48;
        }
        for (int i = 0; i < m; i++) {
            c2[i] = num2.charAt(i) - 48;
        }
        int[] result = new int[m + n];

        for (int j = m - 1; j >= 0; j--) {
            for (int i = n - 1; i >= 0; i--) {
                int t1 = m - j - 1;
                int t2 = n - i - 1;
                int temp = c1[i] * c2[j] + result[t1 + t2];
                result[t1 + t2] = temp % 10;
                result[t1 + t2 + 1] = result[t1 + t2 + 1] + temp / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = result.length - 1;
        int j = 0;
        while (j < result.length - 1 && result[result.length - 1 - j] == 0) {
            i--;
            j++;
        }
        for (; i >= 0; i--) {
            sb.append(result[i]);
        }

        return sb.toString();
    }
    public String multiply2(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int[] c1 = new int[n];
        int[] c2 = new int[m];
        for (int i = 0; i < n; i++) {
            c1[i] = num1.charAt(i) - 48;
        }
        for (int i = 0; i < m; i++) {
            c2[i] = num2.charAt(i) - 48;
        }
        int[] result = new int[m + n];

        for (int j = m - 1; j >= 0; j--) {
            for (int i = n - 1; i >= 0; i--) {
                result[i + j+1] = c1[i] * c2[j] + result[i + j+1];
            }
        }
        for (int i = result.length - 1; i > 0; i--) {
            if (result[i] >= 10) {
                result[i - 1] += result[i] / 10;
                result[i] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < result.length-1 && result[i] == 0) {
            i++;
        }
        for (; i <result.length; i++) {
            sb.append(result[i]);
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "45679";
        String s2 = "0";
        System.out.println(s.multiply2(s1, s2));
    }
}