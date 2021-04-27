package easy.green.slowest_key;
class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int length = releaseTimes.length;
        char[] chars = keysPressed.toCharArray();

        int maxTime = releaseTimes[0];
        char maxChar = chars[0];
        for (int i = 1; i < length; i++) {
            int time = releaseTimes[i] - releaseTimes[i - 1];
            if (time > maxTime) {
                maxTime = time;
                maxChar = chars[i];
            } else if (time == maxTime) {
                maxChar = chars[i] > maxChar ? chars[i] : maxChar;
            }
        }
        return maxChar;
    }
}

