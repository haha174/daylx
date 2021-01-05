package before.text_justification;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        helper(words, 0, maxWidth, res);
        return res;

    }

    // From index "start" on in array "words", select and pack words for a new line.
    // And recursively trigger processing for the next new line from the rest of the words.
    private void helper(String[] words, int start, int maxWidth, List<String> res) {
        StringBuilder sb = new StringBuilder();
        int charLenThisLine = 0; // length of characters for this line
        int i = start;
        for (; i < words.length; i++) {
            sb.append(words[i] + ' ');  // each word is appened with one ' '
            charLenThisLine += (words[i].length() + 1);
            if (charLenThisLine >= (maxWidth + 1)) {
                break;
            }
        }

        if (i == words.length) { // charLenThisLine < (maxWidth + 1)
            for (int j = 0; j < maxWidth - charLenThisLine; j++)
                sb.append(' ');
            res.add(sb.toString());

            return;
        }

        if (charLenThisLine == (maxWidth + 1)) {
            sb.delete(charLenThisLine - 1, charLenThisLine); // delete last ' '
            res.add(sb.toString());

            if (i + 1 < words.length)
                helper(words, i + 1, maxWidth, res);

            return;
        }

        // charLenThisLine > (maxWidth + 1)
        int superfluousLen = words[i].length() + 2; // len of superfluous chars, last words + two ' '
        sb.delete(charLenThisLine - superfluousLen, charLenThisLine);
        charLenThisLine -= superfluousLen;
        // num of words to be padded ' ' at the end, the last word does not need this.
        // 0 means only one word selected, padding all the ' 's at the end of it.
        int wordsNumPacked = i - start - 1;
        int index = 0;
        for (int j = 0; j < maxWidth - charLenThisLine; j++) {
            if (wordsNumPacked == 0) { // 0 means only one word selected
                index = words[start].length();
            } else if ((j % wordsNumPacked) == 0) {
                // index: position at the start of the next word
                index = words[start].length() + 1 + (j / wordsNumPacked);
            } else {
                // index: position at the start of the next word.
                // one more ' ' padded for the previous word should be counted.
                index += (words[start + (j % wordsNumPacked)].length() + 2 + (j / wordsNumPacked));
            }
            sb.insert(index, ' ');
        }
        res.add(sb.toString());
        helper(words, i, maxWidth, res);
    }

    public static void main(String[] args) {

    }
}