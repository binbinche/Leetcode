import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution279 {
/**给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 示例 1:
 输入: n = 12
 输出: 3
 解释: 12 = 4 + 4 + 4.
 示例 2:
 输入: n = 13
 输出: 2
 解释: 13 = 4 + 9.
 * */
//本题目是利用dp算法实现的，因为符合最优子结构和重叠子问题。
    int numSquare(int n){
        int [] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=0;i<=n;i++){
            for(int j=1;i+j*j<=n;j++){
                dp[i+j*j] = Math.min(dp[i+j*j],dp[i]+1);
            }
        }
        return dp[n];
    }
    public static void main(String []args){
        int n = 12;
        Solution279 a = new Solution279();
        int result = a.numSquare(n);
        System.out.println(result);
    }
}
