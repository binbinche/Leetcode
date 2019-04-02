package leetcode;

public class baseNeg2 {
    /**1017. Convert to Base -2
     * Given a number N, return a string consisting of "0"s and "1"s that represents its value in base -2 (negative two).
     * The returned string must have no leading zeroes, unless the string is "0".
     *Example 1:
     * Input: 2
     * Output: "110"
     * Explantion: (-2) ^ 2 + (-2) ^ 1 = 2
     * Example 2:
     * Input: 3
     * Output: "111"
     * Explantion: (-2) ^ 2 + (-2) ^ 1 + (-2) ^ 0 = 3
     * Example 3:
     * Input: 4
     * Output: "100"
     * Explantion: (-2) ^ 2 = 4
     * Note:
     * 0 <= N <= 10^9
     * */
    public String solution1028(int N) {
        if(N == 0)
            return "0";
        StringBuffer s = new StringBuffer("");
        while (N!=0){
            int r = N%(-2);
            N /=(-2);
            if(r<0){
                N +=1;
                r +=2;
            }
            s.append(r);
        }
        String res = reverse(s.toString());
        return res;
    }

    private String reverse(String s) {
        if (s == null || s.equals(""))
            return s;
        return s.charAt(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
    }

    public static void main(String[] args){
        int N= 6;
        baseNeg2 func = new baseNeg2();
        System.out.println(func.solution1028(N));
    }
}
