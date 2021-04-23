package easy.green.crawler_log_folder;

class Solution {
    public int minOperations(String[] logs) {
        int ans = 0;
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].equals("../")) ans = Math.max(0, ans - 1);
            else if(!logs[i].equals("./")) ans++;
        }
        return ans;
    }
}
