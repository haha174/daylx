package hamming_distance;

/**
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 *
 * Note:
 * 0 ≤ x, y < 231.
 *
 * Example:
 *
 * Input: x = 1, y = 4
 *
 * Output: 2
 *
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * The above arrows point to positions where the corresponding bits are different.
 *
 */
class Solution {
//    public int hammingDistance(int x, int y) {
//        int[] xA=new int[32];
//        int[] yA=new int[32];
//        int count=0;
//        getMn(xA,x);
//        getMn(yA,Math.abs(y));
//        if (y<0){
//            // Inverse code
//            for (int i=0;i<31;i++){
//                yA[i]=1-yA[i];
//            }
//            yA[31]=1;
//            //Complement code
//            int c=1;
//            int index=0;
//            while (index<32){
//                if (c+yA[index]==2){
//                    yA[index]=0;
//                }else {
//                    yA[index]=1;
//                    break;
//                }
//
//                index++;
//            }
//        }
//        for (int i=0;i<32;i++){
//            if (yA[i]!=xA[i]){
//                count++;
//            }
//        }
//        return count;
//    }
//    private void getMn( int[] array,int a){
//        int index=0;
//        while (a>0){
//            array[index++]=a%2;
//            a=a/2;
//        }
//    }
public int hammingDistance(int x, int y) {
    x = x^y;
    int hD = 0;
    while(x > 0) {
        if(x % 2 == 1) hD++;
        x /= 2;
    }
    return hD;
}
    public static void main(String[] args) {
        System.out.println(new Solution().hammingDistance(5,-5));
    }
}