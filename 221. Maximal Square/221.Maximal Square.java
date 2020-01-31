class Solution {
    public int maximalSquare(char[][] matrix) {
        int hi = matrix.length;
        if(hi == 0) return 0;
        int wi = matrix[0].length;
        int ans = Math.min(hi,wi);
        while(ans>0){
            for(int i = 0 ; i + ans<=hi ; i++){
                for(int j = 0 ; j + ans <= wi ; j++){
                    boolean allone = true;
                    for(int x = i ;x < i + ans && allone; x++){
                        for(int y = j; y < j + ans && allone; y ++){
                            if(matrix[x][y] == '0') allone = false; 
                        }
                    }
                    if(allone) {
                        return ans*ans;
                    }
                }
            }
            ans--;
        }
        return 0;
    }
}

class Solution {
    public int maximalSquare(char[][] matrix) {
        int hi = matrix.length;
        if(hi == 0) return 0;
        int wi = matrix[0].length;
        int[][] dp =new int[hi][wi];
        int max = 0;
        for(int i = 0 ; i < hi ; i++){
            for(int j = 0 ; j < wi ; j++){
                if(matrix[i][j] == '1'){
                    if(i==0 || j == 0) dp[i][j] = 1;
                    else dp[i][j] = Math.min(dp[i-1][j] , dp[i][j-1]) +1;
                }
                if(dp[i][j] > 1){
                   int temp = dp[i][j];
                   if(matrix[i-temp+1][j-temp+1] != '1') dp[i][j]--;
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max*max;
    }
}
