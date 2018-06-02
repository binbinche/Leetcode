/*题目描述；
	判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
	示例 1:
			输入: 121
			输出: true
	示例 2:
			输入: -121
			输出: false
			解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
	示例 3:
			输入: 10
			输出: false
			解释: 从右向左读, 为 01 。因此它不是一个回文数。
*/			
class Solution {
    public boolean isPalindrome(int x) {
        //特殊情况，小于0 或者为10的倍数。
        if(x<0 ){
            return false;
        }
        int y = 0,z=x;
        while(z!=0)
        {
            y = y*10+z%10;
            z /=10;
        }
        if(y == x)
            return true;
        else
            return false;
    }
}