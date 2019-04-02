package leetcode;

import java.util.ArrayList;
import java.util.List;

public class prefixesDivBy5 {
    /**1018. Binary Prefix Divisible By 5
     *Given an array A of 0s and 1s, consider N_i: the i-th subarray from A[0] to A[i] interpreted as a binary number (from most-significant-bit to least-significant-bit.)
     * Return a list of booleans answer, where answer[i] is true if and only if N_i is divisible by 5.
     * Input: [0,1,1]
     * Output: [true,false,false]
     * Explanation:
     * The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.  Only the first number is divisible by 5, so answer[0] is true.
     * Example 2:
     *
     * Input: [1,1,1]
     * Output: [false,false,false]
     * Example 3:
     *
     * Input: [0,1,1,1,1,1]
     * Output: [true,false,false,false,true,false]
     * Example 4:
     *
     * Input: [1,1,1,0,1]
     * Output: [false,false,false,false,false]
     *
     *
     * Note:
     *
     * 1 <= A.length <= 30000
     * A[i] is 0 or 1
     * */
    List<Boolean> solution1018(int[] A){
        List<Boolean> res = new ArrayList<>();
        int x = 0;
        for(int v :A){
            x = x*2 +v;
            x %=5;
            res.add(x==0);
        }
        return res;
    }
    public static void main(String[] args){
        int[] A = {1,1,1,0,1};
        prefixesDivBy5 func = new prefixesDivBy5();
        System.out.println(func.solution1018(A));
    }
}
