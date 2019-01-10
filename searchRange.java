public class searchRange {
    /**给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     你的算法时间复杂度必须是 O(log n) 级别。
     如果数组中不存在目标值，返回 [-1, -1]。
     示例 1:
     输入: nums = [5,7,7,8,8,10], target = 8
     输出: [3,4]
     示例 2:
     输入: nums = [5,7,7,8,8,10], target = 6
     输出: [-1,-1]*/
    public int[] solution34(int[] nums, int target){
        int len = nums.length;
        int left = findLeft(nums, 0, len-1, target);
        if(left==-1)
            return new int[]{-1,-1};
        int right = findRight(nums,left,len-1,target);

        //System.out.println(left);
        return new int[]{left,right};
    }
    public int findLeft(int[] nums, int l, int r, int target){
        if(l>r || (l ==r && nums[l]!=target))
            return -1;
        else if(l == r)
            return l;
        int mid = (l+r)/2;
        if(nums[mid]< target){
            return findLeft(nums, mid+1,r, target);
        }else if(nums[mid]> target){
            return findLeft(nums, l, mid-1,target);
        }else
            return findLeft(nums,l, mid, target);
    }
    public int findRight(int[] nums, int l, int r, int target){
        if(l>r || (l ==r && nums[l]!=target))
            return -1;
        else if(l == r)
            return r;
        int mid = (l+r+1)/2; //关键点： 这个地方要+1 不然，
        // 就会无限执行findRight(nums,mid,r,target)因为当相邻两个数相同[5,5],则mid始终为0；r始终为1.所以会无限循环下去。
        if(nums[mid]< target){
            return findRight(nums, mid+1,r, target);
        }else if(nums[mid]> target){
            return findRight(nums, l, mid-1,target);
        }else
            return findRight(nums,mid, r, target);
    }
    public static void main(String[]args){
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        searchRange func = new searchRange();
        int [] result = func.solution34(nums,target);
        for(int i = 0;i<result.length;i++)
            System.out.println(result[i]);
    }
}
