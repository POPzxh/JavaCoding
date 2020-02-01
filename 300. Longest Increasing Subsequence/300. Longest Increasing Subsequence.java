    public int lengthOfLIS(int[] nums) {
        int len = 0;
        if((len = nums.length) == 0) return 0;
        int[] dp =new int[len];
        dp[0] = 1;
        for(int i = 1 ; i< len ; i++){
            int max = 1;
            for(int j = 0 ; j<i ; j++){
                max = Math.max(max , dp[j]);
            }
            dp[i] = max;
        }
        return dp[len-1];
    
   }

class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int longest = 1;
        int[] dp = new int[len+1];
        dp[0] = nums[0];
        for(int i = 1 ; i< len ; i++){
            //在dp中找到nums[i]的位置
            int pos = Arrays.binarySearch(dp , 0 , longest , nums[i]);
            if(pos < 0) {//不在dp中，需要更新某个字串的末尾数
                pos = -pos - 1;//pos为第一个大于nums[i]的位置
                if(pos == longest){
                    //nums[i]大于所有的字串末尾数，延伸字串
                    dp[longest] = nums[i];
                    longest++;
                }
                else{
                    //更新末尾数
                    dp[pos] = nums[i];
                }
            }
        }
        return longest;
    }
}
