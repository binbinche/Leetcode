import java.util.ArrayList;
import java.util.List;

public class combinationSum {
    /**给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     candidates 中的数字可以无限制重复被选取。
     说明：
     所有数字（包括 target）都是正整数。
     解集不能包含重复的组合。
     示例 1:
     输入: candidates = [2,3,6,7], target = 7,
     所求解集为:
     [
     [7],
     [2,2,3]
     ]
     示例 2:
     输入: candidates = [2,3,5], target = 8,
     所求解集为:
     [
     [2,2,2,2],
     [2,3,3],
     [3,5]
     ]*/
    public List<List<Integer>> solution39(int[] candidates, int target){
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> a = new ArrayList<>();
        backtracking(list,a,candidates,target,0);
        return list;
    }
    public void backtracking(List<List<Integer>> result, List<Integer> temp, int[] candidates, int target, int k){
        //回溯法
        int sum = getsum(temp); //当和等于目标值时，将list存到result；大于目标值时，回退到上个状态。
        if(sum>target){
            return;
        }
        else if(sum == target)
            result.add(new ArrayList<>(temp));
        else{
            for (int i = k;i<candidates.length;i++){
                temp.add(candidates[i]);
                backtracking(result,temp,candidates,target,i);
                temp.remove(temp.size()-1);
            }
        }
    }
    public int getsum(List<Integer> res){
        int sum = 0;
        for(int i:res){
            sum +=i;
        }
        return sum;
    }
    public static void main(String [] args){
        combinationSum func = new combinationSum();
        int [] candidates = {2,3,8,4};
        int target = 6;
        System.out.println(func.solution39(candidates,target));
    }
}
