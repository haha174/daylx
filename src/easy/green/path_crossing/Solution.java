package easy.green.path_crossing;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> pathSet=new HashSet<>();
        char[] pathArray=path.toCharArray();
        int x=0;
        int y=0;
        String pathStr=x+"-"+y;
        pathSet.add(pathStr);
        for (int i=0;i<pathArray.length;i++){
            if (pathArray[i]=='N'){
                y++;
            }else  if (pathArray[i]=='S'){
                y--;
            }else  if (pathArray[i]=='E'){
                x++;
            }else {
                x--;
            }
             pathStr=x+"-"+y;
            if (pathSet.contains(pathStr)){
                return true;
            }else {
                pathSet.add(pathStr);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPathCrossing("NESWW"));
    }
}