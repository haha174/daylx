package simplify_path;

class Solution {
    public String simplifyPath(String path) {
        if (path == null && path.length() == 0) {
            return "/";
        }
        String[] pathArray = path.split("/");
        String[] result = new String[pathArray.length];
        int index = -1;
        for (int i = 0; i < pathArray.length; i++) {
            if (pathArray[i].length() == 0) {
                continue;
            } else if (pathArray[i].equals(".")) {

            } else if (pathArray[i].equals("..")) {
                index--;
                if (index < -1) {
                    index = -1;
                }
            } else {
                index++;
                result[index] = pathArray[i];
            }
        }
        if (index == -1) {
            return "/";
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= index; i++) {
                sb.append("/");
                sb.append(result[i]);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
       // System.out.println(new Solution().simplifyPath("/../"));
        //System.out.println(new Solution().simplifyPath("/home//foo/"));
        ///System.out.println(new Solution().simplifyPath("/a/./b/../../c/"));
        System.out.println(new Solution().simplifyPath("/a/../../b/../c//.//"));


    }
}