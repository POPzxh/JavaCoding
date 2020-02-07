class Solution {
    public int minSteps(int n) {
        int[][] dp = new int[n+1][n+1];
        dp[1][1] = 1;
        for(int i = 2 ;i <=n ; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1 ; j <= i/2 ; j++ ){
                if(dp[i-j][j]==0) continue;
                dp[i][j] = dp[i-j][j]+1;
                min = Integer.min(min , dp[i][j]);
            }
            if(i==n) return min;
            dp[i][i] = min + 1;
        }
        return 0;
    }
}

class Solution {
    public int minSteps(int n) {
         int d = 2;
        int ans = 0;
        while(n!=1){
            if(n % d == 0){
                ans += d;
                n /= d;
            }
            else d++;
        }
        return ans;
    }
}