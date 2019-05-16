package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class findAndReplacePattern {
    /**
     * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
     * 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
     * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
     * 返回 words 中与给定模式匹配的单词列表。
     * 你可以按任何顺序返回答案。
     * 示例：
     * 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
     * 输出：["mee","aqq"]
     * 解释：
     * "mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
     * "ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
     * 因为 a 和 b 映射到同一个字母。
     * 提示：
     * 1 <= words.length <= 50
     * 1 <= pattern.length = words[i].length <= 20*/
    public List<String> solution890(String[] words, String pattern){
        List<String> strings = new ArrayList<>();
        HashMap map = new HashMap<>();
        HashSet set = new HashSet<>();
        for(String str: words){
            for(int i = 0; i<pattern.length();i++){
                Object s= map.get(pattern.charAt(i))；
                if(s!=null){
                    // 判断pattern中的字母是否被多个字母链接
                    if((char) s!= str.charAt(i)){
                        map = new HashMap();
                        set = new HashSet();
                        break;
                    }
                }else{
                    //这个地方是说明words中的字母可能指向多个pattern中的字母
                    if(set.contains(str.charAt(i))){
                        map = new HashMap<>();
                        set = new HashSet<>();
                        break;
                    }
                    map.put(pattern.charAt(i), str.charAt(i));
                    set.add(str.charAt(i));
                }
                if(i==pattern.length()-1){
                    strings.add(str);
                    map = new HashMap<>();
                    set = new HashSet<>();
                }
            }
        }
        return strings;
    }
    public static void main(String[] args){
        String pattern = "abb";
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        findAndReplacePattern func = new findAndReplacePattern();
        System.out.println(func.solution890(words, pattern));
    }
}
