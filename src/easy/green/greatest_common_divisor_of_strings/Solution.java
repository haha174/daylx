package easy.green.greatest_common_divisor_of_strings;

class Solution {
//        public String gcdOfStrings(String str1, String str2) {
//            for (int i=str2.length()-1;i>=0;i--){
//                if (str2.length()%(i+1)==0){
//                    String result=str2.substring(0,(i+1));
//                    if (str2.replaceAll(result,"").equals("") && str1.replaceAll(result,"").equals("")){
//                        return result;
//                    }
//                }
//            }
//            return "";
//        }

    public String gcdOfStrings(String str1, String str2) {
        if(str1.length()==str2.length()){
            if(str1.equals(str2)) return str1;
            return "";
        }
        int n = gcd(str1.length(),str2.length());
        int m1 = str1.length()/n;
        int m2 = str2.length()/n;
        String order = str1.substring(0,n);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int cnt = 0;
        while(cnt<m1){
            sb1.append(order);
            cnt++;
        }
        cnt = 0;
        while(cnt<m2){
            sb2.append(order);
            cnt++;
        }
        if(str1.equals(sb1.toString())&&str2.equals(sb2.toString())) return order;
        return "";

    }
    private int gcd(int a,int b){
        return a%b==0? b : gcd(b,a%b);
    }
    public static void main(String[] args) {
        System.out.println(new Solution().gcdOfStrings("ABCABC",  "ABC"));
    }
}