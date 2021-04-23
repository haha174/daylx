package easy.green.rearrange_spaces_between_words;

class Solution {
    public String reorderSpaces(String text) {
        // trim去除头尾空格 在JDK11中加入了strip
        String[] splited = text.trim().split("\\s+");
        // String[] splited = text.strip().split("\\s+");
        // System.out.println(Arrays.toString(splited));
        // 记录多少个单词
        int wordCnt = splited.length;
        // 记录单词总长
        int wordLen = 0;
        for(String word : splited) {
            wordLen += word.length();
        }
        // 空格数量
        int spaceCnt = text.length() - wordLen;
        StringBuilder sb = new StringBuilder();
        // 只用在前n-1个单词后面加空格
        for (int i = 0; i < splited.length - 1; i++) {
            sb.append(splited[i]);
            for (int j = 0; j < spaceCnt / (wordCnt - 1); j++) {
                sb.append(" ");
            }
        }
        // 最后一个单词直接加上去
        sb.append(splited[splited.length - 1]);
        // 补齐剩余的空格
        while (sb.length() < text.length()) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
