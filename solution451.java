import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class solution451 {
    /**给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
     示例 1:
     输入:
     "tree"
     输出:
     "eert"
     解释:
     'e'出现两次，'r'和't'都只出现一次。
     因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
     示例 2:
     输入:
     "cccaaa"
     输出:
     "cccaaa"
     解释:
     'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
     注意"cacaca"是不正确的，因为相同的字母必须放在一起。
     示例 3:
     输入:
     "Aabb"
     输出:
     "bbAa"
     解释:
     此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
     注意'A'和'a'被认为是两种不同的字符。*/

    public String frequencySort(String s ){
        //首先将字符串放入哈希表中
        HashMap<Character,Integer>  charsFreMap = new HashMap<>();
        for(int i = 0;i<s.length()-1;i++){
            char c = s.charAt(i);
            charsFreMap.put(c, charsFreMap.getOrDefault(c,0)+1);
        }
        //之后对哈希表按照字符出现的频率排序
        ArrayList<HashMap.Entry<Character,Integer>> list = new ArrayList<>(charsFreMap.entrySet());
        list.sort(new Comparator<HashMap.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        StringBuffer sb = new StringBuffer();
        for(HashMap.Entry<Character,Integer>e:list){
            for(int i=0;i<e.getValue();i++)
                sb.append(e.getKey());
        }
        return sb.toString();
    }
    public static void main(String[] args){
        String s = "leetcode";
        solution451 a = new solution451();
        String result = a.frequencySort(s);
        System.out.println(result);
    }
}
