package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class findSubString {
    /**给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
     注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
     示例 1：
     输入：
     s = "barfoothefoobarman",
     words = ["foo","bar"]
     输出：[0,9]
     解释：
     从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
     输出的顺序不重要, [9,0] 也是有效答案。
     示例 2：
     输入：
     s = "wordgoodgoodgoodbestword",
     words = ["word","good","best","word"]
     输出：[]*/
    public List<Integer> solution30(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || s == null || words.length == 0 || words == null) {
            return res;
        }
        int size = words[0].length();
        int length = words.length * size;
        HashMap<String, Integer> map = strucMap(words);
        for (int i = 0; i <= s.length() - length; i++) {
            HashMap<String, Integer> window = new HashMap<>();
            int left = i;
            int right = i;
            while (right <= s.length() - size && left <= s.length() - length) {
                String subS = s.substring(right, right + size);
                incr(window, subS);
                if (!map.containsKey(subS)) {
                    window.clear();
                    break;
                }
                if (window.get(subS) > map.get(subS)) {
                    window.clear();
                    break;
                }
                right += size;
                if (right - left == length) {
                    res.add(left);
                    window.clear();
                    break;
                }
            }
        }
        return res;
    }

    public HashMap<String, Integer> strucMap(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            incr(map, word);
        }
        return map;
    }

    public void incr(HashMap<String, Integer> map, String s) {
        map.put(s, map.getOrDefault(s, 0) + 1);
    }

    public void del(HashMap<String, Integer> map, String s) {
        int num = map.get(s);
        if (num <= 1) {
            map.remove(s);
        } else {
            map.put(s, num - 1);
        }
    }

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        ArrayList<String> words = new ArrayList<>();
        words.add("word");
        words.add("good");
        words.add("best");
        words.add("word");
        findSubString func = new findSubString();
        System.out.println(func.solution30(s, (String[]) words.toArray(new String[words.size()])));
    }
}
