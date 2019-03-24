package leetcode;

public class smallestRepunitDivByK {
    /**1022. Smallest Integer Divisible by K
     User Accepted: 677
     User Tried: 1745
     Total Accepted: 710
     Total Submissions: 6398
     Difficulty: Medium
     Given a positive integer K, you need find the smallest positive integer N such that N is divisible by K, and N only contains the digit 1.
     Return the length of N.  If there is no such N, return -1.
     Example 1:
     Input: 1
     Output: 1
     Explanation: The smallest answer is N = 1, which has length 1.
     Example 2:
     Input: 2
     Output: -1
     Explanation: There is no such positive integer N divisible by 2.
     Example 3:
     Input: 3
     Output: 3
     Explanation: The smallest answer is N = 111, which has length 3.
     Note:
     1 <= K <= 10^5*/
    public int solution1022(int K){
        int n =0;
        for(int i =0;i<K;i++){
            n = n*10 +1;
            if(n%K==0)
                return i+1;
            else{
                n = n%K;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int k = 3;
        smallestRepunitDivByK func=new smallestRepunitDivByK();
        System.out.println(func.solution1022(k));
    }
}
