package leetcode;

public class canThreePartsEqualSum {
    /**1020. Partition Array Into Three Parts With Equal Sum
     User Accepted: 2115
     User Tried: 2488
     Total Accepted: 2184
     Total Submissions: 4793
     Difficulty: Easy
     Given an array A of integers, return true if and only if we can partition the array into three non-empty parts with equal sums.
     Formally, we can partition the array if we can find indexes i+1 < j with
     (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])
     Example 1:
     Input: [0,2,1,-6,6,-7,9,1,2,0,1]
     Output: true
     Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
     Example 2:
     Input: [0,2,1,-6,6,7,9,-1,2,0,1]
     Output: false
     Example 3:
     Input: [3,3,6,5,-2,2,5,1,-9,4]
     Output: true
     Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
     Note:
     3 <= A.length <= 50000
     -10000 <= A[i] <= 10000*/

    public boolean solution1020(int[] A){
        int sum = 0;
        int ave = 0;
        int len = A.length;
        for(int i =0; i<len; i++){
            sum += A[i];
        }
        if(sum%3!=0)
            return false;
        ave = sum/3;
        int times =0;
        for(int i = 0;i<len;i++){
            ave -= A[i];
            if(ave == 0){
                ave = sum/3;
                times++;
            }
        }
        return times>=3;
    }
    public static void main(String[] args){
        int[] A ={0,2,1,-6,6,-7,9,1,2,0,1};
        canThreePartsEqualSum func = new canThreePartsEqualSum();
        System.out.println(func.solution1020(A));
    }
}
