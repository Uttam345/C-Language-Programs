class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        for(int i=0; i<=m; i++){
            if(i==0) dp[0][i] = true;
            else dp[0][i] = false;
        }
        for(int i=1; i<=m; i++){
            boolean flag = true;
            for(int ii=1; ii<=i; ii++){
                if(p.charAt(ii-1) != '*'){
                    flag = false;
                    break;
                }
            }
            dp[0][i] = flag;
        }
        // So the second loop is necessary to handle the case when the empty string matches a prefix of the pattern consisting entirely of '*'.

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')
                dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1) == '*')
                dp[i][j] = dp[i-1][j] | dp[i][j-1];
                else
                dp[i][j] = false;
            }
        }
        return dp[n][m];
    }
}
