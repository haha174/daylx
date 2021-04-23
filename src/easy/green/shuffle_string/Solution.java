package easy.green.shuffle_string;

class Solution {
    public String restoreString(String s, int[] indices) {
        char[] arr = new char[indices.length];
        StringBuilder sb = new  StringBuilder();
//根据下标把字符放在数组里
        for(int i = 0; i < indices.length;i++){
            arr[indices[i]] = s.charAt(i);
        }
//再连接
        for(int i = 0;i < arr.length;i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
