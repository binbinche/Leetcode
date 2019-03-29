package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class groupAnagrams {
    /**给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     示例:
     输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
     输出:
     [
     ["ate","eat","tea"],
     ["nat","tan"],
     ["bat"]
     ]
     说明：
     所有输入均为小写字母。
     不考虑答案输出的顺序。*/
    public List<List<String>> solution49(String[] strs){
        int[] prime = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};
        //List<List<String>> res = new ArrayList<>();
        HashMap<Integer, List<String>> map = new HashMap<>();
        int len = strs.length;
        for(int i =0;i<len;i++){
            String s = strs[i];
            int sum= 1;
            int slen = s.length();
            for(int j = 0;j<slen;j++){
                sum *=prime[s.charAt(j)-'a'];
            }
            if(map.containsKey(sum)){
                map.get(sum).add(s);
            }else{
                List<String> list= new ArrayList<>();
                list.add(s);
                map.put(sum, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams func = new groupAnagrams();
        System.out.println(func.solution49(strs));
    }
}
