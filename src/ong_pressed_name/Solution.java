package ong_pressed_name;

class Solution {
    public boolean isLongPressedName(String name, String typed) {

        if (name == null || typed == null || typed.length() < name.length()) return false;
        // 比直接char at 效率更高
        char[] ch1 = name.toCharArray();
        char[] ch2 = typed.toCharArray();
        int i = 0, j = 0;
        for (; i < typed.length() ;) {
            if (j<ch1.length &&ch2[i] == ch1[j]) {
                i++;
                j++;
            } else if (j - 1 >= 0 && ch2[i]== ch1[j-1]) {
                i++;
            } else {
                return false;
            }
        }
        if (j==ch1.length){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String name ="vtkgnn",typed="vttkgn";
        //String name = "alex", typed = "aaleex";
        //String name = "saeed", typed = "ssaaedd";
        System.out.println(new Solution().isLongPressedName(name, typed));
    }
}