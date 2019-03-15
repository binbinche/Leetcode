package leetcode;
import java.util.*;
public class permuteUnique {
    /**给定一个可包含重复数字的序列，返回所有不重复的全排列。
     示例:
     输入: [1,1,2]
     输出:
     [
     [1,1,2],
     [1,2,1],
     [2,1,1]
     ]*/
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> solution47(int[] nums){
        res.clear();
        dfs(nums, 0);
        return res;
    }
    private void dfs(int[] nums, int start){
        if(start== nums.length){
            List<Integer> list= new ArrayList<>();
            for(int i = 0;i<nums.length;i++){
                list.add(nums[i]);
            }
            if(!res.contains(list))
                res.add(list);
            //return;
        }
        //如果后面有重复的元素，要确保只和最多1个1交换，最多只和1个2交换，......
        Set<Integer> set = new HashSet<Integer>();
        for(int i = start; i< nums.length; i++) {//i从start开始，如果从start+1开始的话，会把当前序列遗漏掉直接保存了下一个序列
            if(set.contains(nums[i])) {
                continue;
            }

            set.add(nums[i]);//如果不包含的话，设置访问过
            int temp= nums[i];
            nums[i] = nums[start];
            nums[start] = temp;
            dfs(nums, start + 1);//递归下一个位置
            //回到上一个状态
            nums[start] = nums[i];
            nums[i] = temp;
        }
    }
    public static void main(String[] args){
        int[] nums = {1,1,2};
        permuteUnique func = new permuteUnique();
        List<List<Integer>> res = func.solution47(nums);
        System.out.println(res);
    }
}
