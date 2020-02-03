class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if(len == 0) return 0;
        int max = 1;
        int[][] dp = new int[len][len];
        for(int i = 0 ; i < len ;i++){
            dp[i][i] = 1;
            for(int j = i-1 ; j >= 0 ; j--){
                if(s.charAt(j) == s.charAt(i)){
                    dp[j][i] =  dp[j+1][i-1]+2;
                }else dp[j][i] = Math.max(dp[j][i-1] , dp[j+1][i]);
                max = Math.max(max,dp[j][i]);
            }
        }
        return max;
    }
}
