package leetcode;

import java.util.ArrayList;
import java.util.List;

public class partition {
    /**
     * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
     * 返回 s 所有可能的分割方案。
     * 示例:
     * 输入: "aab"
     * 输出:
     * [
     *   ["aa","b"],
     *   ["a","a","b"]
     * ]*/
    public List<List<String>> solution131(String s){
        List<List<String>> result = new ArrayList<>();
        dfs(s, 0,new ArrayList<>(), result);
        return result;
    }
    public void dfs(String s, int index, List<String> list, List<List<String>> result){
        if(index == s.length()){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = index;i<s.length();i++){
            String subStr = s.substring(index,i+1);
            if(isPartition(subStr)){
                list.add(subStr);
                dfs(s, i+1, list, result);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isPartition(String s ){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        String s = "aaabbbbcccc";
        partition func = new partition();
        System.out.println(func.solution131(s));
    }
}
