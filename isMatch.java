package leetcode;

public class isMatch {
    public boolean solution10(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = false;
        }
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = j > 1 && '*' == p.charAt(j - 1) && dp[0][j - 2];
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j];
                } else {
                    dp[i][j] = (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1)) && dp[i - 1][j - 1];
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        isMatch func = new isMatch();
        System.out.println(func.solution10(s, p));
    }
}
