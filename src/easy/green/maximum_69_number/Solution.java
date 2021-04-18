package easy.green.maximum_69_number;

class Solution {
    public int maximum69Number (int num) {
        StringBuffer s=new StringBuffer(Integer.toString(num));
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '6'){
                s.deleteCharAt(i);
                s.insert(i,'9');
                break;
            }
        }
        return Integer.parseInt(s.toString());
    }
}

