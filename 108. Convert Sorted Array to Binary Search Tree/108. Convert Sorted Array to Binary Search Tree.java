class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode node = null;
        if(nums.length > 0){
            int mid = nums.length/2;
            node = new TreeNode(nums[mid]);
            int[] left = new int[0];
            int[] right = new int[0];
            if(mid - 1>= 0)
                left = Arrays.copyOf(nums , mid);
            if(mid + 1 <= nums.length)
                right = Arrays.copyOfRange(nums , mid + 1 , nums.length);
            node.left = sortedArrayToBST(left);
            node.right = sortedArrayToBST(right);
        }
        return node;
    }
}
