package find_common_characters;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> commonChars(String[] A) {
        List<String> result=new ArrayList<String>();
        if (A.length<=1) return result;
        char[] crt=A[0].toCharArray();
        for (int i=0;i<crt.length;i++){
            boolean flag=true;
            for (int j=1;j<A.length;j++){
                if (A[j].indexOf(crt[i])<0){
                    flag=false;
                }
            }
            if(flag){
                String tmp=crt[i]+"";
                result.add(tmp);
                for (int j=0;j<A.length;j++){
                    A[j]= A[j].replaceFirst(tmp,"");
                }
            }
        }
      return result;
    }

    public static void main(String[] args) {
        String[] data={"bella","label","roller"};
        System.out.println(new Solution().commonChars(data));
    }
}