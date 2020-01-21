//dp
class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if(dp[0] == 0 && nums.length != 1) return false;
        for(int i = 1 ; i< nums.length-1 ;i++){
            dp[i] = Math.max(dp[i-1] , i + nums[i]);
            if(dp[i] == i) return false;
        }
        return true;
    }
}
//greedy
class Solution {
    public boolean canJump(int[] nums) {
        int target = nums.length - 1;
        int cur = 0;
        while(cur <= target){
            if(cur == target) return true;
            int max = Integer.MIN_VALUE;
            int temp = cur;
            for(int i = 1 ; i<= nums[cur] ; i++){
                int next = cur + i;
                if(next > target) next = target;
                if(next+ nums[next] > max){
                    max = next + nums[next];
                    temp = next;
                }
            }
            if(cur == temp) return false;
            cur = temp;
        }
        return false;
    }
}
