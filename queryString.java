package leetcode;

public class queryString {
/**1023. Binary String With Substrings Representing 1 To N
 User Accepted: 976
 User Tried: 1095
 Total Accepted: 1029
 Total Submissions: 1707
 Difficulty: Medium
 Given a binary string S (a string consisting only of '0' and '1's) and a positive integer N,
 return true if and only if for every integer X from 1 to N, the binary representation of X is a substring of S.
 Example 1:
 Input: S = "0110", N = 3
 Output: true
 Example 2:
 Input: S = "0110", N = 4
 Output: false
 Note:
 1 <= S.length <= 1000
 1 <= N <= 10^9*/
    public boolean solution1023(String S, int N){
        for(int i =1;i<=N;i++){
            String list = Integer.toBinaryString(i);
            System.out.println(list);
            boolean res = ismatch(S, list);
            if(res)
                continue;
            else
                return false;
        }
        return true;
    }
    private boolean ismatch(String S1, String S2){
        int len1 = S1.length();
        int len2 = S2.length();
        //System.out.println(S2);
        for(int i = 0; i<=len1-len2;i++){
            String temp = S1.substring(i, i+len2);
          //  System.out.println(temp);
            if(temp.equals(S2)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        String S  = "0110";
        int N= 4;
        queryString func = new queryString();
        System.out.println(func.solution1023(S,N));
    }
}
