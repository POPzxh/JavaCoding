class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(k == 1) return true;
        int subSum = 0;
        for(int num : nums) subSum += num;
        Arrays.sort(nums);
        if(subSum % k != 0 || nums[nums.length-1] > subSum/k) return false;
        subSum /= k;
        boolean[] vis = new boolean[nums.length];
        return findPartition(nums , k , vis , subSum , 0);
    }

    public boolean findPartition(int[] nums , int k , boolean[] vis , int subSum , int sum){
        if(sum == subSum){
            if(k == 2) return true;
            return findPartition(nums , k-1 , vis , subSum , 0);
        }
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            if(!vis[i] && nums[i] + sum <= subSum) {
                vis[i] = true;
                if (findPartition(nums, k, vis , subSum , sum + nums[i])) return true;
                vis[i] =false;
            }
        }
        return false;
    }
}
