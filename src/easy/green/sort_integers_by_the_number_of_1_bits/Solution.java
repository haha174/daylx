package easy.green.sort_integers_by_the_number_of_1_bits;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;

class Solution {
    public int[] sortByBits(int[] arr) {
        Arrays.sort(arr);
        int[] indexArr=new int[arr.length];
        int[] result=new int[arr.length];
        int[] countArr=new int[33];
        for (int i=0;i<arr.length;i++){
            int temp=getOneCount(arr[i]);
            indexArr[i]=temp;
            countArr[temp]++;
        }
        int lastCount=0;
        for (int i=0;i<countArr.length-1;i++){
            lastCount+=countArr[i];
        }
        countArr[countArr.length-1]=lastCount;

        for (int i=countArr.length-2;i>=0;i--){
            countArr[i]=countArr[i+1]-countArr[i];
        }

        for (int i=0;i<arr.length;i++){
            int count=countArr[indexArr[i]];
            countArr[indexArr[i]]++;
            result[count]=arr[i];
        }


        return result;
    }

    private int getOneCount(int num) {
        int result = 0;
        while (num > 0) {
            if (num % 2 == 1) {
                result++;
            }
            num = num / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data={0,1,2,3,4,5,6,7,8};
        System.out.println(new Solution().sortByBits(data));
    }
}