package keyboard_row;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: ['Hello', 'Alaska', 'Dad', 'Peace']
 * Output: ['Alaska', 'Dad']
 */
class Solution {
    static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('q', 1);
        map.put('w', 1);
        map.put('e', 1);
        map.put('r', 1);
        map.put('t', 1);
        map.put('y', 1);
        map.put('u', 1);
        map.put('i', 1);
        map.put('o', 1);
        map.put('p', 1);
        map.put('a', 2);
        map.put('s', 2);
        map.put('d', 2);
        map.put('f', 2);
        map.put('g', 2);
        map.put('h', 2);
        map.put('j', 2);
        map.put('k', 2);
        map.put('l', 2);
        map.put('z', 3);
        map.put('x', 3);
        map.put('c', 3);
        map.put('v', 3);
        map.put('b', 3);
        map.put('n', 3);
        map.put('m', 3);

    }

    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        for (String str : words) {
            char[] data = str.toCharArray();
            boolean flag = true;
            int current = map.get(Character.toLowerCase(data[0]));
            for (char c : data) {
                if (map.get(Character.toLowerCase(c)) != current) {
                    flag = false;
                    break;
                }
            }
            if (flag){
                list.add(str);
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {
        String[] data={"Hello","Alaska","Dad","Peace"};
        System.out.println(new Solution().findWords(data));
    }
}