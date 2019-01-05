public class serch {
    /**假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     你可以假设数组中不存在重复的元素。
     你的算法时间复杂度必须是 O(log n) 级别。
     示例 1:
     输入: nums = [4,5,6,7,0,1,2], target = 0
     输出: 4
     示例 2:
     输入: nums = [4,5,6,7,0,1,2], target = 3
     输出: -1*/

    public int solution33(int []nums,int target){
        return find(nums,0, nums.length-1,target);
    }
    private int find(int[] nums, int low, int high, int target){
        if(low>high)
            return -1;
        int mid  = (low+high)/2;
        if(nums[mid]==target)
            return mid;
        if(nums[mid]<nums[high]){
            if(nums[mid]<target && target<=nums[high])
                return find(nums,mid+1,high,target);
            else
                return find(nums,low,mid-1,target);

        }
        else{
            if(nums[mid]>target && target>=nums[low])
                return find(nums, low, mid-1,target);
            else
                return find(nums, mid+1,high,target);
        }
    }
    public static void main(String[] args){
        int []nums ={4,5,6,7,0,1,2};
        int target = 0;
        serch func = new serch();
        int result = func.solution33(nums, target);
        System.out.println(result);
    }
}
