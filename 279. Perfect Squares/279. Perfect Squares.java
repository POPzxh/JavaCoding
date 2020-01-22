class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n +1];
        for(int i = 1 ;i<= n ; i++){
            int base = (int) Math.floor(Math.sqrt(i));
            if(base * base == i) dp[i] = 1;
            else {
                int min = Integer.MAX_VALUE;
                for(int b = 1 ; b <= base ; b++){
                    if(1 + dp[i-b*b] < min) min = 1+dp[i-b*b];
                }
                dp[i] = min;
            }
        }
        //System.out.println(Arrays.toString(dp));
        return dp[n];        
    }
}
