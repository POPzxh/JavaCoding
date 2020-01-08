class Solution {
    public int search(int[] nums, int target) {
        int find = -1;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi && find == -1){
            if(nums[lo] == target) return lo;
            if(nums[hi] == target) return hi;
            int mid = (lo + hi) / 2;
            if(nums[mid] == target) find = mid;
            if(nums[mid] > nums[hi]){
                if(target > nums[lo] && target < nums[mid]) hi = mid-1;
                else lo = mid + 1;
            }else{
                if(target > nums[mid] && target < nums[hi]) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return find;
    }
}
