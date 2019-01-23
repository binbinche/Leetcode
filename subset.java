import java.util.ArrayList;
import java.util.List;

public class subset {
    /**给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     说明：解集不能包含重复的子集。
     示例:
     输入: nums = [1,2,3]
     输出:
     [
     [3],
     [1],
     [2],
     [1,2,3],
     [1,3],
     [2,3],
     [1,2],
     []
     ]*/
    public List<List<Integer>> solution78(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length==0)
            return result;
        dfs(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }
    public void dfs(List<List<Integer>> result, List<Integer> temp, int[] nums, int start){
        result.add(new ArrayList<>(temp));//添加到结果集中
        //注意点：因为子集不考虑顺序，
        for(int i=start; i<nums.length;i++){
            temp.add(nums[i]);
            dfs(result,temp, nums, i+1);//将temp添加到结果集中并添加下一个数
            temp.remove(temp.size()-1);//移除最新添加的一个数继续循环
        }
    }
    public static void main(String[] args){
        int[] nums = {1,2,3};
        subset func = new subset();
        List<List<Integer>> result = func.solution78(nums);
        System.out.println(result);
    }
}
