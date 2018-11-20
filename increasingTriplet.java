public class increasingTriplet {
    /**
    给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
    数学表达式如下：
    如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
    使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
    说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
    示例 1:

    输入: [1,2,3,4,5]
    输出: true
    示例 2:

    输入: [5,4,3,2,1]
    输出: false */
    public boolean increasingTriplet(int [] nums){
        if(nums.length<3)
            return false;
        int c1 = Integer.MAX_VALUE;
        int c2 = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]<c1){
                c1= nums[i];
            }else if(nums[i]<c2){
                c2 = nums[i];
            }else
                return true;
        }
        return false;
    }
    public static void main(String []args){
        increasingTriplet a = new increasingTriplet();
        int [] nums = {1,2,3,4,5};
        boolean flag = a.increasingTriplet(nums);
        System.out.println(flag);
    }
}
