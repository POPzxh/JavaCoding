class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        boolean[] vis= new boolean[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int step = 0 ; step < 2; step++) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if(vis[i]) continue;
                while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    ans[i] = stack.peek();
                    vis[i] = true;
                    stack.push(nums[i]);
                } else {
                    stack.push(nums[i]);
                    ans[i] = -1;
                }
            }
        }
        return ans;
    }
}