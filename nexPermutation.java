package leetcode;

public class nexPermutation {
    /**实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     必须原地修改，只允许使用额外常数空间。
     以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
     1,2,3 → 1,3,2
     3,2,1 → 1,2,3
     1,1,5 → 1,5,1*/
    public void solution31(int[] nums){
        int len = nums.length-1;
        int exIndex = len-1;
        while(exIndex>=0 && nums[exIndex+1]<=nums[exIndex])
            exIndex--;
        if(exIndex>=0){
            int j = len;
            while (j>=exIndex && nums[j] <= nums[exIndex])
                j--;
            swap(nums, j, exIndex);
        }
        reverse(nums, exIndex+1, len);
    }
    private void reverse(int[] nums, int start, int end){
        while(start<end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    private void swap(int[] nums, int j, int i){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        int[] nums = {5,1,1};
        nexPermutation func = new nexPermutation();
        func.solution31(nums);
        for(int i =0;i<nums.length;i++)
            System.out.println(nums[i]);
    }
}
