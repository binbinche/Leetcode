import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class fourNumsToSum {
    public List<List<Integer>> fourSum(int []nums,int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int one=0;one<nums.length-3;one++){
            if(one>0 && nums[one]==nums[one-1])
                continue;
            int first_target = target-nums[one];
            for(int two=one+1;two<nums.length-2;two++){
                if(two>one+1 && nums[two]==nums[two-1])
                    continue;
                int second_target = first_target-nums[two];
                int left = two+1;
                int right = nums.length-1;
                while(left<right){
                    if(nums[left]+nums[right]==second_target){
                        result.add(Arrays.asList(nums[one],nums[two],nums[left],nums[right]));
                        left++;
                        while(left<right && nums[left]==nums[left-1]) left++;
                    }else if(nums[left]+nums[right]<second_target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String []args){
        fourNumsToSum a  = new fourNumsToSum();
        int [] nums = {-3,-2,-1,0,0,1,2,3};
        int target =0;
        List<List<Integer>> result= a.fourSum(nums,target);
        System.out.println(result);
    }
}
