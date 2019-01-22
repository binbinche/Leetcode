import java.util.ArrayList;
import java.util.List;

public class permute {
    public List<List<Integer>> solution46(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<Integer>(), nums);
        return result;
    }
    public void dfs(List<List<Integer>> result, List<Integer> res,int[] nums){
        if(res.size()==nums.length){
            result.add(new ArrayList<>(res));
        }else{
            for(int i =0;i<nums.length;i++){
                if(res.contains(nums[i]))
                    continue;
                res.add(nums[i]);
                dfs(result,res,nums);
                res.remove(res.size()-1);
            }
        }
    }
    public static void main(String[] args){
        int[] nums ={1,2,3};
        permute func = new permute();
        List<List<Integer>> result = func.solution46(nums);
        System.out.println(result);
    }
}
