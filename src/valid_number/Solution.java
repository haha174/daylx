package valid_number;



class Solution {
    public boolean isNumber(String s) {
        if(s==null || s.length()==0) return false;
        boolean seenE = false;
        boolean seenD = false;
        boolean seenN = false;

        s = s.trim();
        for(int i =0; i < s.length(); ++i){

            char c = s.charAt(i);
            switch (c){
                case '.' : if(seenD||seenE) return false;
                    seenD = true;
                    break;

                case 'e' : if(seenE||!seenN) return false;
                    seenE = true;
                    seenN = false;
                    break;

                case '+' :
                case '-':
                    if(i!=0 && s.charAt(i-1)!='e') return false;
                    seenN = false;
                    break;

                default:
                    if(c-'0'<0||c-'0'>9) return false;
                    seenN = true;
            }

        }
        return seenN;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().isNumber(".1e1"));

    }
}