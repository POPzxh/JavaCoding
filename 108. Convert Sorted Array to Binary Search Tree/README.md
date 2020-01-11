# 108. Convert Sorted Array to Binary Search Tree

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of *every* node never differ by more than 1.

**Example:**

```
Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
```

### 思路

因为是递增的数组，所以很自然地想到了中序遍历。

递归，每次将数组的中点作为当前节点，左侧为左节点，右侧为右节点

```java
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
```

